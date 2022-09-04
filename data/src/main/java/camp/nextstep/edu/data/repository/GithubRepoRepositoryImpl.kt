package camp.nextstep.edu.data.repository

import android.util.Log
import camp.nextstep.edu.data.local.GithubRepoEntityDao
import camp.nextstep.edu.data.mapper.toGithubRepo
import camp.nextstep.edu.data.mapper.toGithubRepoEntity
import camp.nextstep.edu.data.remote.GithubApi
import camp.nextstep.edu.data.remote.dto.GithubRepoDto
import camp.nextstep.edu.domain.model.GithubRepo
import camp.nextstep.edu.domain.repository.GithubRepoRepository
import javax.inject.Inject

internal class GithubRepoRepositoryImpl @Inject constructor(
	private val githubApi: GithubApi,
	private val githubRepoEntityDao: GithubRepoEntityDao,
) : GithubRepoRepository {

	override suspend fun fetchGithubRepos(): List<GithubRepo> {
		runCatching {
			githubApi.fetchGithubRepos()
		}.onSuccess {
			cachingApiFetchResult(it)
		}.onFailure {
			Log.d("GithubRepository", "Fetching github repositories failed", it)
		}

		return getAllGithubReposFromDB()
	}

	private suspend fun cachingApiFetchResult(githubRepoDtoList: List<GithubRepoDto>) {
		val githubRepoEntityList = githubRepoDtoList.map { it.toGithubRepoEntity() }

		runCatching {
			githubRepoEntityDao.insertAll(*githubRepoEntityList.toTypedArray())
		}.onFailure {
			Log.d("GithubRepository", "Caching github repositories failed", it)
		}
	}

	private suspend fun getAllGithubReposFromDB(): List<GithubRepo> {
		return runCatching {
			githubRepoEntityDao.selectAll().map { it.toGithubRepo() }
		}.getOrElse {
			Log.d("GithubRepository", "Selecting github repositories failed", it)

			emptyList()
		}
	}
}