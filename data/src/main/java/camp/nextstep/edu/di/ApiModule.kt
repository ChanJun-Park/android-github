package camp.nextstep.edu.di

import camp.nextstep.edu.data.remote.GithubApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApiModule {

	@Provides
	@Singleton
	fun provideOkHttpClient(): OkHttpClient {
		return OkHttpClient.Builder()
			.addInterceptor(
				HttpLoggingInterceptor().apply {
					level = HttpLoggingInterceptor.Level.BODY
				}
			)
			.build()
	}

	@Provides
	@Singleton
	fun provideRetrofit(client: OkHttpClient): Retrofit {
		return Retrofit.Builder()
			.baseUrl(GithubApi.BASE_URL)
			.addConverterFactory(MoshiConverterFactory.create())
			.client(client)
			.build()
	}

	@Provides
	@Singleton
	fun provideGithubApi(retrofit: Retrofit): GithubApi {
		return retrofit.create(GithubApi::class.java)
	}

}