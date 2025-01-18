package com.example.rickandmorty.di

import com.example.rickandmorty.data.network.ApiFactory
import com.example.rickandmorty.data.network.ApiService
import com.example.rickandmorty.data.repository.RepositoryApiImpl
import com.example.rickandmorty.domain.repository.RepositoryApi
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
interface DataModule {

    @Binds
    @ApplicationScope
    fun bindRepositoryApiImpl(impl: RepositoryApiImpl): RepositoryApi

    companion object{
        @Provides
        @ApplicationScope
        fun provideApiService(): ApiService = ApiFactory.apiService
    }
}