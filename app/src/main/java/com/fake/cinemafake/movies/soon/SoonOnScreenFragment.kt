package com.fake.cinemafake.movies.soon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fake.cinemafake.databinding.FragmentSoonOnScreenBinding
import com.fake.cinemafake.movies.util.ExtractMovies

class SoonOnScreenFragment : Fragment() {

    private lateinit var binding: FragmentSoonOnScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSoonOnScreenBinding.inflate(layoutInflater)

        context?.let { ExtractMovies().getMovieList(it, binding.listViewActualMovies) }

        return binding.root
    }

}