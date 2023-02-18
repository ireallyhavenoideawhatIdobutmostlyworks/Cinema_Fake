package com.fake.cinemafake.movies.util

import android.content.Context
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.fake.cinemafake.R
import com.fake.cinemafake.movies.api.MoviesApiInterface
import com.fake.cinemafake.movies.api.MoviesDetailsPayload
import com.fake.cinemafake.movies.api.MoviesResponsePayload
import com.fake.cinemafake.movies.api.RetrofitConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class ExtractMovies {

    fun getMovieList(context: Context, listView: ListView) {
        val retrofit = RetrofitConfig.prepareRetrofitConfig()
        val apiResponse = retrofit.create(MoviesApiInterface::class.java)

        apiResponse.getMovieList(todayDateForRequest())?.enqueue(object : Callback<MoviesResponsePayload?> {
            override fun onResponse(
                call: Call<MoviesResponsePayload?>,
                response: Response<MoviesResponsePayload?>
            ) {

                val movieResponse = getMovieResponse(response)
                val detailsList = getMoviesDetails(movieResponse)
                listView(listView).adapter = MoviesListAdapter(context, detailsList)
            }

            override fun onFailure(call: Call<MoviesResponsePayload?>, t: Throwable) {
                t.localizedMessage?.let {
                    Log.e("Error", it)
                }
                Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun getMovieResponse(response: Response<MoviesResponsePayload?>): MoviesResponsePayload {
        return response.body() as MoviesResponsePayload
    }

    private fun getMoviesDetails(movieResponse: MoviesResponsePayload): ArrayList<MoviesDetailsPayload> {
        return movieResponse.body!!.moviesDetailsPayload;
    }

    private fun listView(listView: ListView): ListView {
        return listView.findViewById(R.id.list_view_actual_movies)
    }

    private fun todayDateForRequest(): String {
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
    }
}