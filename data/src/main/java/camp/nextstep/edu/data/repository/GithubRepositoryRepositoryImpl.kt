package camp.nextstep.edu.data.repository

import android.util.Log
import camp.nextstep.edu.data.local.GithubRepositoryEntityDao
import camp.nextstep.edu.data.mapper.toGithubRepository
import camp.nextstep.edu.data.mapper.toGithubRepositoryEntity
import camp.nextstep.edu.data.remote.GithubApi
import camp.nextstep.edu.data.remote.dto.GithubRepositoryDto
import camp.nextstep.edu.domain.model.GithubRepository
import camp.nextstep.edu.domain.repository.GithubRepositoryRepository
import javax.inject.Inject

internal class GithubRepositoryRepositoryImpl @Inject constructor(
	private val githubApi: GithubApi,
	private val githubRepositoryEntityDao: GithubRepositoryEntityDao,
) : GithubRepositoryRepository {

	override suspend fun fetchGithubRepositories(): List<GithubRepository> {
		runCatching {
			githubApi.fetchGithubRepositories()
		}.onSuccess {
			cachingApiFetchResult(it)
		}.onFailure {
			Log.d("GithubRepository", "Fetching github repositories failed", it)
		}

		return getAllGithubRepositoriesFromDB()
	}

	private suspend fun cachingApiFetchResult(githubRepositoryDtoList: List<GithubRepositoryDto>) {
		val githubRepositoryEntityList = githubRepositoryDtoList.map { it.toGithubRepositoryEntity() }

		runCatching {
			githubRepositoryEntityDao.insertAll(*githubRepositoryEntityList.toTypedArray())
		}.onFailure {
			Log.d("GithubRepository", "Caching github repositories failed", it)
		}
	}

	private suspend fun getAllGithubRepositoriesFromDB(): List<GithubRepository> {
		return runCatching {
			githubRepositoryEntityDao.selectAll().map { it.toGithubRepository() }
		}.getOrElse {
			Log.d("GithubRepository", "Selecting github repositories failed", it)

			emptyList()
		}
	}
}