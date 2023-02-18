package com.fake.cinemafake.user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import com.fake.cinemafake.R
import com.fake.cinemafake.databinding.FragmentLoginBinding
import com.fake.cinemafake.databinding.FragmentLoginRegisterBinding
import com.fake.cinemafake.user.login.LoginFragment
import com.fake.cinemafake.user.register.RegisterFragment

class LoginRegisterFragment : Fragment() {

    private lateinit var binding: FragmentLoginRegisterBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLoginRegisterBinding.inflate(layoutInflater)

        setDefaultFragment(LoginFragment())
        clickGoToFragmentBtn(binding.btnLogin, LoginFragment())
        clickGoToFragmentBtn(binding.btnRegister, RegisterFragment())

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
            replace(R.id.fragment_login_register_placeholder, fragment)
            setReorderingAllowed(true)
        }
    }


}