package com.example.paging3practice.di

import com.example.paging3practice.domain.usecase.FetchGithubRepositoriesUseCase
import com.example.paging3practice.presenter.GithubPagingSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object PagingSourceModule {

    @Provides
    @ViewModelScoped
    fun providesGithubPagingSource(
        useCase: FetchGithubRepositoriesUseCase
    ) = GithubPagingSource(fetchGithubRepositoriesUseCase = useCase)
}
