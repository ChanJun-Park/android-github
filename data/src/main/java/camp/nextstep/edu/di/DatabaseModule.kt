package camp.nextstep.edu.di

import android.app.Application
import androidx.room.Room
import camp.nextstep.edu.data.local.GithubRepositoryDatabase
import camp.nextstep.edu.data.local.GithubRepositoryEntityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DatabaseModule {

	companion object {
		@Provides
		@Singleton
		internal fun provideGithubRepositoryDatabase(application: Application): GithubRepositoryDatabase {
			return Room.databaseBuilder(
				application,
				GithubRepositoryDatabase::class.java,
				"github_repository"
			).build()
		}

		@Provides
		@Singleton
		internal fun provideGithubRepositoryEntityDao(githubRepositoryDatabase: GithubRepositoryDatabase): GithubRepositoryEntityDao {
			return githubRepositoryDatabase.githubRepositoryEntityDao
		}
	}
}