package com.example.paging3practice.di

import com.example.paging3practice.data.remote.GithubAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class APIModule {

    @Provides
    @Singleton
    fun providesGithubAPI(retrofit: Retrofit) =
        retrofit.create(GithubAPI::class.java)
}