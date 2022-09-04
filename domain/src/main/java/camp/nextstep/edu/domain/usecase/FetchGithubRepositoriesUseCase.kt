package camp.nextstep.edu.domain.usecase

import camp.nextstep.edu.domain.model.GithubRepository
import camp.nextstep.edu.domain.repository.GithubRepositoryRepository
import javax.inject.Inject

class FetchGithubRepositoriesUseCase @Inject constructor(
	private val githubRepositoryRepository: GithubRepositoryRepository
) {
	suspend operator fun invoke(): List<GithubRepository> {
		return githubRepositoryRepository.fetchGithubRepositories()
	}
}