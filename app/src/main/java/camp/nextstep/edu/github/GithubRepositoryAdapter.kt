package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.domain.model.GithubRepository
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class GithubRepositoryAdapter : ListAdapter<GithubRepository, GithubRepositoryAdapter.GithubRepositoryViewHolder>(GithubRepositoryDiffCallback()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepositoryViewHolder {
		return GithubRepositoryViewHolder.create(parent)
	}

	override fun onBindViewHolder(holder: GithubRepositoryViewHolder, position: Int) {
		if (position < 0 || itemCount < position) return

		holder.setItem(getItem(position))
	}

	class GithubRepositoryViewHolder private constructor(
		private val binding: ItemRepoBinding
	) : RecyclerView.ViewHolder(binding.root) {

		fun setItem(githubRepository: GithubRepository) {
			binding.githubRepository = githubRepository
		}

		companion object {
			fun create(parent: ViewGroup): GithubRepositoryViewHolder {
				val layoutInflater = LayoutInflater.from(parent.context)
				val binding = ItemRepoBinding.inflate(layoutInflater, parent, false)

				return GithubRepositoryViewHolder(binding)
			}
		}
	}
}

private class GithubRepositoryDiffCallback : DiffUtil.ItemCallback<GithubRepository>() {
	override fun areItemsTheSame(oldItem: GithubRepository, newItem: GithubRepository): Boolean {
		return oldItem.id == newItem.id
	}

	override fun areContentsTheSame(oldItem: GithubRepository, newItem: GithubRepository): Boolean {
		return oldItem == newItem
	}
}