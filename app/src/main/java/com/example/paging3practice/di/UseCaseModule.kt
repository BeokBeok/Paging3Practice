package com.example.paging3practice.di

import com.example.paging3practice.domain.repository.GithubRepository
import com.example.paging3practice.domain.usecase.FetchGithubRepositoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun provideFetchGithubRepositoriesUseCase(githubRepository: GithubRepository) =
        FetchGithubRepositoriesUseCase(githubRepository = githubRepository)
}
