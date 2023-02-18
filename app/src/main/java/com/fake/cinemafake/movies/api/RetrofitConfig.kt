package com.fake.cinemafake.movies.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    private const val baseUrl = "https://www.cinema-city.pl/pl/data-api-service/v1/"


    fun prepareRetrofitConfig(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}