package camp.nextstep.edu.domain.repository

import camp.nextstep.edu.domain.model.GithubRepository

interface GithubRepositoryRepository {

	suspend fun fetchGithubRepositories(): List<GithubRepository>

}