package com.example.rickandmorty.data.repository

import com.example.rickandmorty.data.network.ApiService
import com.example.rickandmorty.data.network.model.ListRickDto
import com.example.rickandmorty.data.network.model.toListRick
import com.example.rickandmorty.domain.model.Info
import com.example.rickandmorty.domain.model.InfoRick
import com.example.rickandmorty.domain.model.Location
import com.example.rickandmorty.domain.model.Origin
import com.example.rickandmorty.domain.model.Results
import com.example.rickandmorty.domain.repository.RepositoryApi
import javax.inject.Inject

class RepositoryApiImpl @Inject constructor(private val apiService: ApiService) : RepositoryApi {

    override suspend fun getListRick(): Results {
        val result: ListRickDto = apiService.getInfoRick().results
        return result.toListRick()
    }

    override suspend fun getInfoRick(): List<InfoRick> {
        val listRick: List<InfoRick> = getListRick().listInfoRick
        return listRick
    }

    override suspend fun getInfo(): Info {
        val info: Info = apiService.getInfoRick().info
        return info
    }

    override suspend fun getOrigin(): Origin {
        TODO("Not yet implemented")
    }

    override suspend fun getLocation(): Location {
        TODO("Not yet implemented")
    }

}