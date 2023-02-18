package com.fake.cinemafake.movies.api

import com.google.gson.annotations.SerializedName

data class MoviesResponsePayload(

    @SerializedName("body") var body: MoviesBodyResponsePayload? = MoviesBodyResponsePayload()
)
