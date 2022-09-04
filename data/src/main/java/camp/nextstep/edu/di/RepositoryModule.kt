package camp.nextstep.edu.di

import camp.nextstep.edu.data.repository.GithubRepositoryRepositoryImpl
import camp.nextstep.edu.domain.repository.GithubRepositoryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

	@Singleton
	@Binds
	abstract fun provideGithubRepositoryRepository(githubRepositoryRepositoryImpl: GithubRepositoryRepositoryImpl): GithubRepositoryRepository
}