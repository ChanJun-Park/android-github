package camp.nextstep.edu.data.remote

import camp.nextstep.edu.data.remote.dto.GithubRepositoryDto
import retrofit2.http.GET

interface GithubApi {

	@GET("repositories")
	suspend fun fetchGithubRepositories(): List<GithubRepositoryDto>

	companion object {
		const val BASE_URL = "https://api.github.com/"
	}
}