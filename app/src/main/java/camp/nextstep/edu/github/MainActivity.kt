package camp.nextstep.edu.github

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import camp.nextstep.edu.github.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
	private val viewModel: MainViewModel by viewModels()
	private lateinit var binding: ActivityMainBinding
	private lateinit var adapter: GithubRepositoryAdapter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		initRecyclerView()

		collectData()
	}

	private fun initRecyclerView() {
		adapter = GithubRepositoryAdapter()
		binding.githubRepositoriesRecyclerView.adapter = adapter
	}

	private fun collectData() {
		lifecycleScope.launch {
			repeatOnLifecycle(Lifecycle.State.STARTED) { collectGithubRepositories() }
		}
	}

	private suspend fun collectGithubRepositories() {
		viewModel.githubRepositories.collectLatest {
			adapter.submitList(it)
		}
	}
}