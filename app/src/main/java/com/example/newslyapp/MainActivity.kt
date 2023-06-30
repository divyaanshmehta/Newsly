package com.example.newslyapp

import HomeFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.newslyapp.databinding.ActivityMainBinding
import com.example.newslyapp.Fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Get the NavHostFragment using the ID specified in the XML layout
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        // Get the NavController from the NavHostFragment
        navController = navHostFragment.navController

        binding.btn0.setOnClickListener {
            navController.navigate(R.id.homeFragment)
        }

        binding.btn1.setOnClickListener {
            navController.navigate(R.id.businessNewsFragment)
        }

        binding.btn2.setOnClickListener {
            navController.navigate(R.id.scienceNewsFragment)
        }

        binding.btn3.setOnClickListener {
            navController.navigate(R.id.sportsNewsFragment)
        }

        binding.btn4.setOnClickListener {
            navController.navigate(R.id.technologyNewsFragment)
        }

        binding.btn5.setOnClickListener {
            navController.navigate(R.id.healthNewsFragment)
        }

        binding.btn6.setOnClickListener {
            navController.navigate(R.id.entertainmentNewsFragment)
        }

        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                // Close the app
                finish()
            }
        })
    }


}
