package com.fake.cinemafake.user.account

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fake.cinemafake.R
import com.fake.cinemafake.databinding.FragmentAccountBinding
import com.fake.cinemafake.databinding.FragmentLoginRegisterBinding
import com.fake.cinemafake.user.login.LoginFragment
import com.fake.cinemafake.user.register.RegisterFragment

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAccountBinding.inflate(layoutInflater)


        return binding.root
    }

}