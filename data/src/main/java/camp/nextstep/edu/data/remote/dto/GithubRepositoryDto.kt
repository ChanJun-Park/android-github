package camp.nextstep.edu.data.remote.dto

import com.squareup.moshi.Json

data class GithubRepositoryDto(
	@field:Json(name = "full_name")
	val fullName: String,
	val description: String
)
