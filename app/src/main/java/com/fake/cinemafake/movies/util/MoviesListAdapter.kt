package com.fake.cinemafake.movies.util

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.fake.cinemafake.R
import com.fake.cinemafake.movies.api.MovieGenreEnum
import com.fake.cinemafake.movies.api.MoviesDetailsPayload
import com.squareup.picasso.Picasso

class MoviesListAdapter(private val context: Context, private val moviesDetailsList: List<MoviesDetailsPayload>) : BaseAdapter() {

    override fun getCount(): Int {
        return moviesDetailsList.size
    }

    override fun getItem(itemPosition: Int): MoviesDetailsPayload {
        return moviesDetailsList[itemPosition]
    }

    override fun getItemId(itemPosition: Int): Long {
        return itemPosition.toLong()
    }

    override fun getView(itemPosition: Int, convertView: View?, parent: ViewGroup?): View? {
        var itemListView = convertView

        if (itemListView == null) {
            itemListView =
                LayoutInflater.from(context).inflate(R.layout.movies_item, parent, false)
        }

        val item = getItem(itemPosition)
        setImage(itemListView, item)
        setTitle(itemListView, item)
        setGenre(itemListView, item)

        return itemListView
    }

    private fun setImage(myConvertView: View?, item: MoviesDetailsPayload) {
        val itemImage = myConvertView?.findViewById<ImageView>(R.id.image_view_item_movie)
        Picasso
            .get()
            .load(item.posterLink)
            .into(itemImage)
    }

    private fun setTitle(myConvertView: View?, item: MoviesDetailsPayload) {
        val itemTitle = myConvertView?.findViewById<TextView>(R.id.text_view_item_title)
        itemTitle?.text = item.name
    }

    private fun setGenre(myConvertView: View?, item: MoviesDetailsPayload) {
        val itemGenre = myConvertView?.findViewById<TextView>(R.id.text_view_item_genre)

        val genreListOutput: MutableList<String> = prepareGenreList(item)

        if (genreListOutput.isNotEmpty()) {
            itemGenre?.text = formattedGenreTextView(genreTextViewPrefix(), genreListAsString(genreListOutput))
        } else {
            Toast.makeText(context, "Please try later", Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepareGenreList(item: MoviesDetailsPayload): MutableList<String> {
        val listOutput: MutableList<String> = mutableListOf()

        for (attribute in item.attributeIds) {
            for (enum in MovieGenreEnum.values()) {
                if (isMatchBetweenGenreNames(attribute, enum)) {
                    listOutput.add(enum.genre)
                }
            }
        }

        return listOutput
    }

    private fun isMatchBetweenGenreNames(attribute: String, enum: MovieGenreEnum): Boolean {
        return attribute == enum.name.lowercase().replace("_", "-")
    }

    private fun formattedGenreTextView(textViewPrefix: String, genreListAsString: String): String {
        return String.format(textViewPrefix, genreListAsString)
    }

    private fun genreTextViewPrefix(): String {
        return "Rodzaj: %s";
    }

    private fun genreListAsString(listOutput: MutableList<String>): String {
        return listOutput.joinToString(", ")
    }
}