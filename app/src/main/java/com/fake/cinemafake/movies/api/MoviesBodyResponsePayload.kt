package com.fake.cinemafake.movies.api

import com.google.gson.annotations.SerializedName

class MoviesBodyResponsePayload {

    @SerializedName("films")
    var moviesDetailsPayload: ArrayList<MoviesDetailsPayload> = arrayListOf()
}