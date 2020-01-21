package com.example.cinemasearcher.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitService {

    private const val BASE_URL = "https://api.themoviedb.org/"


    fun start(): MoviesAPI {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
        return retrofit.create(MoviesAPI::class.java)
    }

}











