package camp.nextstep.edu.data.remote.dto

import com.squareup.moshi.Json

internal data class GithubRepoDto(
	val id: Int,
	@field:Json(name = "full_name")
	val fullName: String,
	val description: String?
)
