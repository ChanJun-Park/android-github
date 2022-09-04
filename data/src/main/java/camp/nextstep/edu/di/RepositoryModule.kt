package camp.nextstep.edu.di

import camp.nextstep.edu.data.local.GithubRepositoryEntityDao
import camp.nextstep.edu.data.remote.GithubApi
import camp.nextstep.edu.data.repository.GithubRepositoryRepositoryImpl
import camp.nextstep.edu.domain.repository.GithubRepositoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

	companion object {
		@Provides
		@Singleton
		fun provideGithubRepositoryRepository(githubApi: GithubApi, githubRepositoryEntityDao: GithubRepositoryEntityDao): GithubRepositoryRepository {
			return GithubRepositoryRepositoryImpl(githubApi, githubRepositoryEntityDao)
		}
	}
}