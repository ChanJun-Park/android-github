package camp.nextstep.edu.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.domain.model.GithubRepo
import camp.nextstep.edu.github.databinding.ItemRepoBinding

class GithubRepoAdapter : ListAdapter<GithubRepo, GithubRepoAdapter.GithubRepoViewHolder>(GithubRepoDiffCallback()) {

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoViewHolder {
		return GithubRepoViewHolder.create(parent)
	}

	override fun onBindViewHolder(holder: GithubRepoViewHolder, position: Int) {
		if (position < 0 || itemCount < position) return

		holder.setItem(getItem(position))
	}

	class GithubRepoViewHolder private constructor(
		private val binding: ItemRepoBinding
	) : RecyclerView.ViewHolder(binding.root) {

		fun setItem(githubRepo: GithubRepo) {
			binding.githubRepo = githubRepo
		}

		companion object {
			fun create(parent: ViewGroup): GithubRepoViewHolder {
				val layoutInflater = LayoutInflater.from(parent.context)
				val binding = ItemRepoBinding.inflate(layoutInflater, parent, false)

				return GithubRepoViewHolder(binding)
			}
		}
	}
}

private class GithubRepoDiffCallback : DiffUtil.ItemCallback<GithubRepo>() {
	override fun areItemsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
		return oldItem.id == newItem.id
	}

	override fun areContentsTheSame(oldItem: GithubRepo, newItem: GithubRepo): Boolean {
		return oldItem == newItem
	}
}