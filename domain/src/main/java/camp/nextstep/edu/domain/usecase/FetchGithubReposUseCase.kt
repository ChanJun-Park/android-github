package camp.nextstep.edu.domain.usecase

import camp.nextstep.edu.domain.model.GithubRepo
import camp.nextstep.edu.domain.repository.GithubRepoRepository
import javax.inject.Inject

class FetchGithubReposUseCase @Inject constructor(
	private val githubRepoRepository: GithubRepoRepository
) {
	suspend operator fun invoke(): List<GithubRepo> {
		return githubRepoRepository.fetchGithubRepos()
	}
}