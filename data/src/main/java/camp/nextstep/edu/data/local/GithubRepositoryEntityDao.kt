package camp.nextstep.edu.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import camp.nextstep.edu.data.local.entity.GithubRepositoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GithubRepositoryEntityDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(githubRepositoryEntity: GithubRepositoryEntity)

	@Query("SELECT * FROM GithubRepositoryEntity")
	fun selectAll(): Flow<GithubRepositoryEntity>
}