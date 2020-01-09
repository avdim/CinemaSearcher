package com.example.cinemasearcher.network

import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitService {

    companion object {

        private val BASE_URL = "http://www.omdbapi.com/"

        // получаю объект ретрофит, содержащий базовый URL
        // и способность преобразовывать даные
        fun start(): MoviesAPI {
            val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(MoviesAPI::class.java)
        }

    }
    // объект для получения запросов
    //val moviesAPI: MoviesAPI = retrofit.create(MoviesAPI::class.java)
    //val call: Call<Movies> = moviesAPI.getMovies().execute(Call<Movies>)
}








