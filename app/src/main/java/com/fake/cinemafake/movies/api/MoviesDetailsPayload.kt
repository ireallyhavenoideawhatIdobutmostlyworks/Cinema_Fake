package com.fake.cinemafake.movies.api

import com.google.gson.annotations.SerializedName

data class MoviesDetailsPayload(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("length") var length: Int? = null,
    @SerializedName("posterLink") var posterLink: String? = null,
    @SerializedName("videoLink") var videoLink: String? = null,
    @SerializedName("link") var link: String? = null,
    @SerializedName("weight") var weight: Int? = null,
    @SerializedName("releaseYear") var releaseYear: String? = null,
    @SerializedName("attributeIds") var attributeIds: ArrayList<String> = arrayListOf()
)
