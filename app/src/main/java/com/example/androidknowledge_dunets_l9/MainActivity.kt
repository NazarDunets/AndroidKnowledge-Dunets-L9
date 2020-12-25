package com.example.androidknowledge_dunets_l9

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidknowledge_dunets_l9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setOnClickListeners()
        setupFragments()
    }

    private fun setupFragments() {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.top_container, StartingFragment.newInstance())
            .commit()
    }

    private fun setOnClickListeners() {
        binding.launchButton.setOnClickListener {
            val serviceIntent = Intent(this, ArithmeticService::class.java)
            startService(serviceIntent)
        }
    }

    private fun setupBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}