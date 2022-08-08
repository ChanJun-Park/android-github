package camp.nextstep.edu.github.githubListAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.Github

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 05..
 */
class GithubListAdapter :
    ListAdapter<Github, GithubListViewHolder>(GithubListDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubListViewHolder {
        val itemRepoBinding =
            ItemRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GithubListViewHolder(itemRepoBinding)
    }

    override fun onBindViewHolder(holder: GithubListViewHolder, position: Int) {
        holder.setData(getItem(holder.adapterPosition))
    }
}