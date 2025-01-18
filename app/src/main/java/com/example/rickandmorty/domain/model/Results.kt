package com.example.rickandmorty.domain.model

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("results")
    var listInfoRick: List<InfoRick>
)