package com.nextstep.edu.data.remote

import camp.nextstep.edu.data.remote.GithubApi
import camp.nextstep.edu.data.remote.dto.GithubRepositoriesResponse
import camp.nextstep.edu.data.remote.dto.GithubRepositoryDto
import com.google.common.truth.Truth.assertThat
import com.nextstep.edu.data.MainCoroutineRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

@OptIn(ExperimentalCoroutinesApi::class)
@Suppress("NonAsciiCharacters")
class GithubApiTest {

	@get:Rule
	val mainCoroutineRule = MainCoroutineRule()

	private lateinit var mockWebServer: MockWebServer
	private lateinit var githubApi: GithubApi

	@Before
	fun setup() {
		mockWebServer = MockWebServer()
		githubApi = Retrofit.Builder()
			.baseUrl(mockWebServer.url("/"))
			.addConverterFactory(MoshiConverterFactory.create().asLenient())
			.build()
			.create(GithubApi::class.java)
	}

	@After
	fun tearDown() {
		mockWebServer.close()
	}

	@Test
	fun `github 저장소 리스트를 불러와서 GithubRepositoryDto 모델로 파싱하는지 테스트`() = runTest(UnconfinedTestDispatcher()) {
		val encoded = Files.readAllBytes(Paths.get("src/test/resources/api/response/github_repository_response.txt"))
		val fakeResponse = String(encoded, StandardCharsets.UTF_8)

		mockWebServer.enqueue(MockResponse().setBody(fakeResponse))

		val response = githubApi.fetchGithubRepositories()

		val expectedResponse =
			listOf(
				GithubRepositoryDto(
					fullName = "mojombo/grit",
					description = "**Grit is no longer maintained. Check out libgit2/rugged.** Grit gives you object oriented read/write access to Git repositories via Ruby."
				)
			)

		assertThat(response).isEqualTo(expectedResponse)
	}
}