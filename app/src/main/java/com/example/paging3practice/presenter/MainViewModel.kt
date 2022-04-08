package com.example.paging3practice.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.paging3practice.domain.model.Repo
import com.example.paging3practice.domain.usecase.FetchGithubRepositoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOf

@HiltViewModel
class MainViewModel @Inject constructor(
    private val githubPagingSource: GithubPagingSource
) : ViewModel() {

    var pagingData: Flow<PagingData<Repo>> = flowOf()
        private set

    fun fetchRepos() {
        pagingData = Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { githubPagingSource }
        ).flow.cachedIn(viewModelScope)
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 30
    }
}
