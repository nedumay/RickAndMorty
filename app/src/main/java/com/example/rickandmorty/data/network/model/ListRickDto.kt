package com.example.rickandmorty.data.network.model

import com.example.rickandmorty.domain.model.InfoRick
import com.example.rickandmorty.domain.model.Results
import com.google.gson.annotations.SerializedName

data class ListRickDto(
    @SerializedName("results")
    val results: List<InfoRick> = listOf()
)

fun ListRickDto.toListRick(): Results {
    return Results(results)
}