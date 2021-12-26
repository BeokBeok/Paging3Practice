package com.example.paging3practice.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.paging3practice.R
import com.example.paging3practice.databinding.ViewHolderRepoBinding
import com.example.paging3practice.domain.model.Repo

class RepoViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {

    private val binding: ViewHolderRepoBinding = ViewHolderRepoBinding.bind(itemView)

    fun bind(repo: Repo?) {
        if (repo == null) return
        binding.tvRepoFullName.text = repo.fullName
    }

    companion object {
        fun create(parent: ViewGroup): RepoViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_repo, parent, false)
            return RepoViewHolder(view)
        }
    }
}