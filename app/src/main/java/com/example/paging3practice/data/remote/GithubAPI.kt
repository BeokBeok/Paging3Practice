package com.example.paging3practice.data.remote

import com.example.paging3practice.data.entity.RepoSearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPI {

    @GET("search/repositories?sort=stars")
    suspend fun fetchRepos(
        @Query("q") query: String = "Android",
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): RepoSearchResponse
}