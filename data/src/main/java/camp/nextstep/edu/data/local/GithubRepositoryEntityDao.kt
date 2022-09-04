package camp.nextstep.edu.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import camp.nextstep.edu.data.local.entity.GithubRepositoryEntity

@Dao
internal interface GithubRepositoryEntityDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(githubRepositoryEntity: GithubRepositoryEntity)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertAll(vararg githubRepositoryEntity: GithubRepositoryEntity)

	@Query("SELECT * FROM GithubRepositoryEntity")
	suspend fun selectAll(): List<GithubRepositoryEntity>
}