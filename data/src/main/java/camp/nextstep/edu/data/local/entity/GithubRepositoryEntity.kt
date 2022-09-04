package camp.nextstep.edu.data.local.entity

import androidx.room.Entity

@Entity
data class GithubRepositoryEntity(
	val fullName: String,
	val description: String
)