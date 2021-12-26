package com.example.paging3practice.di

import com.example.paging3practice.domain.repository.GithubRepository
import com.example.paging3practice.domain.usecase.FetchGithubRepositoriesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Provides
    @Singleton
    fun provideFetchGithubRepositoriesUseCase(githubRepository: GithubRepository) =
        FetchGithubRepositoriesUseCase(githubRepository = githubRepository)
}