package camp.nextstep.edu.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import camp.nextstep.edu.data.local.entity.GithubRepositoryEntity

@Database(entities = [GithubRepositoryEntity::class], version = 1, exportSchema = false)
internal abstract class GithubRepositoryDatabase : RoomDatabase() {
	abstract val githubRepositoryEntityDao: GithubRepositoryEntityDao
}