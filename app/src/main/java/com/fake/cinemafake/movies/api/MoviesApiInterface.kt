package com.fake.cinemafake.movies.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesApiInterface {

    @GET("quickbook/10103/film-events/in-cinema/1078/at-date/{date}?attr=&lang=pl_PL&films")
    fun getMovieList(@Path("date") date: String): Call<MoviesResponsePayload?>?
}