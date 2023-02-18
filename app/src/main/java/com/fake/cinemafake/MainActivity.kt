package com.fake.cinemafake

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.fake.cinemafake.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.widgetToolbar)
        navController = findNavController(R.id.nav_host_fragment)

        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.movies_destination), binding.drawerLayoutActivityMain)

        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navigationDrawer.setupWithNavController(navController)

        setupClickListener()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }

    private fun setupClickListener() {
        binding.navigationDrawer.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = !menuItem.isChecked

            when (menuItem.itemId) {
                R.id.navigation_menu_movies -> {
                    navController.navigate(R.id.action_movies_to_movies)
                }

                R.id.navigation_menu_login_register -> {
                    navController.navigate(R.id.action_movies_to_login_register)
                }

                R.id.navigation_menu_account -> {
                    navController.navigate(R.id.action_movies_to_account)
                }
            }

            binding.drawerLayoutActivityMain.closeDrawer(GravityCompat.START)

            true
        }
    }
}