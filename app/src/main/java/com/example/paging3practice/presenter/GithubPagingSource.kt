package com.example.paging3practice.presenter

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3practice.domain.model.Repo
import com.example.paging3practice.domain.usecase.FetchGithubRepositoriesUseCase

class GithubPagingSource(
    private val fetchGithubRepositoriesUseCase: FetchGithubRepositoriesUseCase
) : PagingSource<Int, Repo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Repo> = runCatching {
        val position = params.key ?: START_PAGE
        val items = fetchGithubRepositoriesUseCase
            .execute(
                page = position,
                perPage = params.loadSize
            )
        LoadResult.Page(
            data = items,
            prevKey = if (position == START_PAGE) null else position - 1,
            nextKey = if (items.isEmpty()) null else position + (params.loadSize / PER_PAGE)
        )
    }.getOrElse {
        LoadResult.Error(it)
    }

    override fun getRefreshKey(state: PagingState<Int, Repo>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }

    companion object {
        private const val START_PAGE = 1
        private const val PER_PAGE = 30
    }
}