package camp.nextstep.edu.github.githubListAdapter

import androidx.recyclerview.widget.RecyclerView
import camp.nextstep.edu.github.databinding.ItemRepoBinding
import camp.nextstep.edu.github.domain.Github

/**
 * 클래스에 대한 간단한 설명이나 참고 url을 남겨주세요.
 * Created by jeongjinhong on 2022. 08. 05..
 */
class GithubListViewHolder(
    private val binding: ItemRepoBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun setData(data: Github) {
        binding.fullName.text = data.fullName
        binding.description.text = data.description
    }
}