package com.fake.cinemafake.movies

import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.fake.cinemafake.R
import com.fake.cinemafake.databinding.FragmentMoviesBinding
import com.fake.cinemafake.movies.actual.ActualOnScreenFragment
import com.fake.cinemafake.movies.soon.SoonOnScreenFragment
import com.fake.cinemafake.movies.tickets.MyTicketsFragment


class MoviesFragment : Fragment() {

    private lateinit var binding: FragmentMoviesBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMoviesBinding.inflate(layoutInflater)

        setDefaultFragment(ActualOnScreenFragment())
        clickGoToFragmentBtn(binding.btnMyTickets, MyTicketsFragment())
        clickGoToFragmentBtn(binding.btnActualOnScreen, ActualOnScreenFragment())
        clickGoToFragmentBtn(binding.btnSoonOnScreen, SoonOnScreenFragment())

        return binding.root
    }

    private fun setDefaultFragment(fragment: Fragment) {
        replaceFragment(fragment)
    }

    private fun clickGoToFragmentBtn(button: Button, fragment: Fragment) {
        button.setOnClickListener {
            replaceFragment(fragment)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        parentFragmentManager.commit {
            replace(R.id.fragment_movies_placeholder, fragment)
            setReorderingAllowed(true)
        }
    }
}