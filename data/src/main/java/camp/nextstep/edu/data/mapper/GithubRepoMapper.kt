package camp.nextstep.edu.data.mapper

import camp.nextstep.edu.data.local.entity.GithubRepoEntity
import camp.nextstep.edu.data.remote.dto.GithubRepoDto
import camp.nextstep.edu.domain.model.GithubRepo

internal fun GithubRepo.toGithubRepoEntity(): GithubRepoEntity = GithubRepoEntity(id, fullName, description)

internal fun GithubRepoEntity.toGithubRepo(): GithubRepo = GithubRepo(id, fullName, description)

internal fun GithubRepoDto.toGithubRepoEntity(): GithubRepoEntity = GithubRepoEntity(id, fullName, description)