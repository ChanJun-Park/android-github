package camp.nextstep.edu.data.mapper

import camp.nextstep.edu.data.local.entity.GithubRepositoryEntity
import camp.nextstep.edu.data.remote.dto.GithubRepositoryDto
import camp.nextstep.edu.domain.model.GithubRepository

internal fun GithubRepository.toGithubRepositoryEntity(): GithubRepositoryEntity = GithubRepositoryEntity(id, fullName, description)

internal fun GithubRepositoryEntity.toGithubRepository(): GithubRepository = GithubRepository(id, fullName, description)

internal fun GithubRepositoryDto.toGithubRepositoryEntity(): GithubRepositoryEntity = GithubRepositoryEntity(id, fullName, description)