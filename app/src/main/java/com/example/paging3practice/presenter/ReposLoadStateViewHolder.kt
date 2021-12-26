package com.example.paging3practice.presenter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3practice.R
import com.example.paging3practice.databinding.ViewHolderReposLoadStateBinding

class ReposLoadStateViewHolder private constructor(
    private val binding: ViewHolderReposLoadStateBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.btnReposLoadState.setOnClickListener { retry.invoke() }
    }

    fun bind(loadState: LoadState) {
        binding.pbReposLoadState.isVisible = loadState is LoadState.Loading
        binding.btnReposLoadState.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): ReposLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_repos_load_state, parent, false)
            val binding = ViewHolderReposLoadStateBinding.bind(view)
            return ReposLoadStateViewHolder(binding, retry)
        }
    }
}