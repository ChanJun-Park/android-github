package camp.nextstep.edu.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubRepositoryEntity(
	@PrimaryKey
	val id: Int,
	val fullName: String,
	val description: String
)