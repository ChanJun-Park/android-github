package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.domain.model.GithubRepo
import camp.nextstep.edu.domain.model.GithubRepoList
import camp.nextstep.edu.domain.usecase.FetchGithubReposUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val fetchGithubRepos: FetchGithubReposUseCase
): ViewModel() {
	private val _githubRepos = MutableStateFlow<GithubRepoList>(GithubRepoList(emptyList()))
	val githubRepos: StateFlow<GithubRepoList> = _githubRepos.asStateFlow()

	init {
		fetchRepos()
	}

	private fun fetchRepos() {
		viewModelScope.launch {
			_githubRepos.value = fetchGithubRepos()
		}
	}
}