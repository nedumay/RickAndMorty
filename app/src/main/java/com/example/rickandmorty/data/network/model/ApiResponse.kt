package com.example.rickandmorty.data.network.model

import com.example.rickandmorty.domain.model.Info
import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("info") val info: Info,
    @SerializedName("results") val results: ListRickDto

)
