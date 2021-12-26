package com.example.paging3practice.domain.repository

import com.example.paging3practice.domain.model.Repo

interface GithubRepository {

    suspend fun fetchRepos(page: Int, perPage: Int) : List<Repo>
}