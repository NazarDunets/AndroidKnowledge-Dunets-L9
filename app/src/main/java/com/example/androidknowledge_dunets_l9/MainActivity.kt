package com.example.androidknowledge_dunets_l9

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.Color
import android.graphics.PorterDuff
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var launchButton: Button
    private val filter = IntentFilter("com.example.androidknowledge_dunets_l9.broadcast.NUMBER")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launchButton = findViewById(R.id.launch_button)

        launchButton.setOnClickListener {
            val serviceIntent = Intent(this, ArithmeticService::class.java)
            startService(serviceIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(updateReceiver, filter)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(updateReceiver)
    }

    private val updateReceiver = object : BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {

            val serviceResult = intent.getIntExtra("result", 0)

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.top_container, StartingFragment.newInstance(serviceResult))
                .commit()
        }
    }

}