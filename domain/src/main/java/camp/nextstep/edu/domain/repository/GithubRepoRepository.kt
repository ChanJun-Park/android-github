package camp.nextstep.edu.domain.repository

import camp.nextstep.edu.domain.model.GithubRepoList

interface GithubRepoRepository {

	suspend fun fetchGithubRepos(): GithubRepoList

}