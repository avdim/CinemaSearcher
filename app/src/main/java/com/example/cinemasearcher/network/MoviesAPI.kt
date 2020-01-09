package com.example.cinemasearcher.network

import retrofit2.Call
import retrofit2.http.GET


interface MoviesAPI {

    @GET("?s=superman&apikey=52750b21")
    fun getMovies(): Call<Movies>
}