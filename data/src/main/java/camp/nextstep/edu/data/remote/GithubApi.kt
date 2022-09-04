package camp.nextstep.edu.data.remote

import camp.nextstep.edu.data.remote.dto.GithubRepoDto
import retrofit2.http.GET

internal interface GithubApi {

	@GET("repositories")
	suspend fun fetchGithubRepos(): List<GithubRepoDto>

	companion object {
		const val BASE_URL = "https://api.github.com/"
	}
}