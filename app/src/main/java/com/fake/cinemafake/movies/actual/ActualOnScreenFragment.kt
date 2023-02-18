package com.fake.cinemafake.movies.actual

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fake.cinemafake.databinding.FragmentActualOnScreenBinding
import com.fake.cinemafake.movies.util.ExtractMovies

class ActualOnScreenFragment : Fragment() {

    private lateinit var binding: FragmentActualOnScreenBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentActualOnScreenBinding.inflate(layoutInflater)

        context?.let { ExtractMovies().getMovieList(it, binding.listViewActualMovies) }

        return binding.root
    }
}