package camp.nextstep.edu.di

import camp.nextstep.edu.data.repository.GithubRepoRepositoryImpl
import camp.nextstep.edu.domain.repository.GithubRepoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {

	@Singleton
	@Binds
	abstract fun provideGithubRepoRepository(githubRepoRepositoryImpl: GithubRepoRepositoryImpl): GithubRepoRepository
}