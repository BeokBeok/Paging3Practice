package com.example.paging3practice.domain.usecase

import com.example.paging3practice.domain.model.Repo
import com.example.paging3practice.domain.repository.GithubRepository

class FetchGithubRepositoriesUseCase(
    private val githubRepository: GithubRepository
) {

    suspend fun execute(page: Int, perPage: Int): List<Repo> =
        githubRepository.fetchRepos(page = page, perPage = perPage)
}