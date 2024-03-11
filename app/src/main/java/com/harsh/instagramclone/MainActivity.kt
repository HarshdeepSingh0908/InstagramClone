package com.harsh.instagramclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.harsh.instagramclone.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        navController = findNavController(R.id.navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.homeFragment,
                R.id.searchFragment,
                R.id.newPostFragment,
                R.id.reelsFragment,
                R.id.profileFragment
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item_home -> {
                    navController.navigate((R.id.homeFragment))
                }

                R.id.item_search -> {
                    navController.navigate((R.id.searchFragment))
                }

                R.id.item_new_post -> {
                    navController.navigate((R.id.newPostFragment))
                }

                R.id.item_reels -> {
                    navController.navigate((R.id.reelsFragment))
                }

                R.id.item_profile -> {
                    navController.navigate((R.id.profileFragment))
                }

            }
            return@setOnItemSelectedListener true
        }
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> binding.bottomMenu.menu.getItem(0).isChecked = true
                R.id.searchFragment -> binding.bottomMenu.menu.getItem(1).isChecked = true
                R.id.newPostFragment -> binding.bottomMenu.menu.getItem(2).isChecked = true
                R.id.reelsFragment-> binding.bottomMenu.menu.getItem(3).isChecked = true
                R.id.profileFragment-> binding.bottomMenu.menu.getItem(4).isChecked = true

            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.popBackStack()

    }
}