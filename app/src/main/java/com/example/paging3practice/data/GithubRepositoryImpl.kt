package com.example.paging3practice.data

import com.example.paging3practice.data.mapper.toModel
import com.example.paging3practice.data.remote.GithubAPI
import com.example.paging3practice.domain.model.Repo
import com.example.paging3practice.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val githubAPI: GithubAPI
) : GithubRepository {

    override suspend fun fetchRepos(page: Int, perPage: Int): List<Repo> =
        githubAPI.fetchRepos(page = page, perPage = perPage)
            .items
            .toModel()
}