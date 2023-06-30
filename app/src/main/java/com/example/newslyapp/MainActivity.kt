package com.example.newslyapp

import HomeFragment
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import com.example.newslyapp.databinding.ActivityMainBinding
import com.example.newslyapp.fragments.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val businessNewsFragment = BusinessNewsFragment()
        val scienceNewsFragment = ScienceNewsFragment()
        val sportsNewsFragment = SportsNewsFragment()
        val technologyNewsFragment = TechnologyNewsFragment()
        val healthNewsFragment = HealthNewsFragment()
        val entertainmentNewsFragment = EntertainmentNewsFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, homeFragment)
            .commit()

        binding.btn0.setOnClickListener {
            showFragment(homeFragment)
        }
        binding.btn1.setOnClickListener {
            showFragment(businessNewsFragment)
        }

        binding.btn2.setOnClickListener {
            showFragment(scienceNewsFragment)
        }

        binding.btn3.setOnClickListener {
            showFragment(sportsNewsFragment)
        }

        binding.btn4.setOnClickListener {
            showFragment(technologyNewsFragment)
        }

        binding.btn5.setOnClickListener {
            showFragment(healthNewsFragment)
        }

        binding.btn6.setOnClickListener {
            showFragment(entertainmentNewsFragment)
        }
    }


    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
