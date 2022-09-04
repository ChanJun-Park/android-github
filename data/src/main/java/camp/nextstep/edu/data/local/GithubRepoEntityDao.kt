package camp.nextstep.edu.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import camp.nextstep.edu.data.local.entity.GithubRepoEntity

@Dao
internal interface GithubRepoEntityDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insert(githubRepoEntity: GithubRepoEntity)

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertAll(vararg githubRepoEntity: GithubRepoEntity)

	@Query("SELECT * FROM GithubRepoEntity")
	suspend fun selectAll(): List<GithubRepoEntity>
}