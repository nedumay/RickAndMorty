package com.example.rickandmorty.domain.repository

import com.example.rickandmorty.domain.model.Info
import com.example.rickandmorty.domain.model.InfoRick
import com.example.rickandmorty.domain.model.Location
import com.example.rickandmorty.domain.model.Origin
import com.example.rickandmorty.domain.model.Results

interface RepositoryApi {

    suspend fun getListRick(): Results

    suspend fun getInfoRick(): List<InfoRick>

    suspend fun getInfo(): Info

    suspend fun getOrigin(): Origin

    suspend fun getLocation(): Location
}