package com.example.paging3practice.di

import com.example.paging3practice.data.GithubRepositoryImpl
import com.example.paging3practice.domain.repository.GithubRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindsGithubRepository(impl: GithubRepositoryImpl): GithubRepository
}