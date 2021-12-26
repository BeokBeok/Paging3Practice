package com.example.paging3practice.presenter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3practice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        showContent()

        val reposAdapter = ReposAdapter().apply {
            binding.rvMain.adapter = withLoadStateFooter(ReposLoadStateAdapter { retry() } )
        }

        binding.rvMain.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy != 0) showContent()
            }
        })

        lifecycleScope.launch {
            viewModel.pagingData.collectLatest(reposAdapter::submitData)
        }

        lifecycleScope.launch {
            reposAdapter.loadStateFlow.collect { loadState ->
                val isEmptyList = loadState.refresh is LoadState.NotLoading && reposAdapter.itemCount == 0
                binding.rvMain.isVisible = !isEmptyList
                binding.pbMain.isVisible = loadState.source.refresh is LoadState.Loading
                binding.btnMainRetry.isVisible = loadState.source.refresh is LoadState.Error
            }
        }
    }

    private fun showContent() {
        viewModel.fetchRepos()
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}