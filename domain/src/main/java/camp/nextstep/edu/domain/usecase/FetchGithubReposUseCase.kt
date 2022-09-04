package camp.nextstep.edu.domain.usecase

import camp.nextstep.edu.domain.model.GithubRepoList
import camp.nextstep.edu.domain.repository.GithubRepoRepository
import javax.inject.Inject

class FetchGithubReposUseCase @Inject constructor(
	private val githubRepoRepository: GithubRepoRepository
) {
	suspend operator fun invoke(): GithubRepoList {
		return githubRepoRepository.fetchGithubRepos()
	}
}