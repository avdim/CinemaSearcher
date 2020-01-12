package com.example.cinemasearcher.network

import com.google.gson.annotations.SerializedName

data class Movies(
    @SerializedName("title")
    val title: String,
    @SerializedName("year")
    val year: Int,
    @SerializedName("imdbID")
    val imdbID: Int,
    @SerializedName("type")
    val type: String,
    @SerializedName("poster")
    val posterURL: String
)


