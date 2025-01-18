package com.example.rickandmorty.data.network

import com.example.rickandmorty.data.network.model.ApiResponse
import retrofit2.http.GET

interface ApiService {

    @GET("character")
    suspend fun getInfoRick(): ApiResponse
}