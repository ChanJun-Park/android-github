package camp.nextstep.edu.github.data

import com.google.gson.annotations.SerializedName

internal data class GithubRepositoryDTO(
    @SerializedName("full_name") val fullName: String,
    @SerializedName("description") val description: String?
)