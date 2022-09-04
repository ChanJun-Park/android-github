package camp.nextstep.edu.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import camp.nextstep.edu.data.local.entity.GithubRepoEntity

@Database(entities = [GithubRepoEntity::class], version = 1, exportSchema = false)
internal abstract class GithubRepoDatabase : RoomDatabase() {
	abstract val githubRepoEntityDao: GithubRepoEntityDao
}