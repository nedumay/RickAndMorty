package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.network.ApiService
import com.example.rickandmorty.domain.model.Info
import com.example.rickandmorty.domain.model.InfoRick
import com.example.rickandmorty.domain.repository.RepositoryApi
import javax.inject.Inject

class RepositoryApiImpl @Inject constructor(private val apiService: ApiService) : RepositoryApi {

    override suspend fun getInfoRick(): List<InfoRick> {
        val result: List<InfoRick> = apiService.getApiInfo().results
        return result
    }

    override suspend fun getInfo(): Info {
        val info: Info = apiService.getApiInfo().info
        return info
    }

}