package camp.nextstep.edu.di

import android.app.Application
import androidx.room.Room
import camp.nextstep.edu.data.local.GithubRepoDatabase
import camp.nextstep.edu.data.local.GithubRepoEntityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DatabaseModule {

	companion object {
		@Provides
		@Singleton
		internal fun provideGithubRepoDatabase(application: Application): GithubRepoDatabase {
			return Room.databaseBuilder(
				application,
				GithubRepoDatabase::class.java,
				"github_repo"
			).build()
		}

		@Provides
		@Singleton
		internal fun provideGithubRepoEntityDao(githubRepoDatabase: GithubRepoDatabase): GithubRepoEntityDao {
			return githubRepoDatabase.githubRepoEntityDao
		}
	}
}