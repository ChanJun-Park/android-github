package camp.nextstep.edu.github

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import camp.nextstep.edu.domain.model.GithubRepository
import camp.nextstep.edu.domain.usecase.FetchGithubRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val fetchGithubRepositories: FetchGithubRepositoriesUseCase
): ViewModel() {
	private val _githubRepositories = MutableStateFlow<List<GithubRepository>>(emptyList())
	val githubRepositories: StateFlow<List<GithubRepository>> = _githubRepositories.asStateFlow()

	init {
		fetchRepositories()
	}

	private fun fetchRepositories() {
		viewModelScope.launch {
			_githubRepositories.value = fetchGithubRepositories()
		}
	}
}