package com.example.cinemasearcher.network

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MoviesAPI {

//    @GET("movie/popular/")
//    fun getMovies(): Call<ArrayList<Movies>>

    @GET("movie/popular/")
    fun getMovies(): Observable<ArrayList<Movies>>

//    @GET("movie/{id}")
//    fun getMovieById(@Path("id") id:Int): Call<ArrayList<Movies>>
}

