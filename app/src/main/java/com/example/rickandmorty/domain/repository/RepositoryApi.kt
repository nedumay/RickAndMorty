package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.domain.model.Info
import com.example.rickandmorty.domain.model.InfoRick

interface RepositoryApi {

    suspend fun getInfoRick(): List<InfoRick>

    suspend fun getInfo(): Info

}