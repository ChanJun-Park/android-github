package camp.nextstep.edu.domain.repository

import camp.nextstep.edu.domain.model.GithubRepo

interface GithubRepoRepository {

	suspend fun fetchGithubRepos(): List<GithubRepo>

}