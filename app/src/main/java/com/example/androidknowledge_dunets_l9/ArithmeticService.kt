package com.example.androidknowledge_dunets_l9

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import kotlin.random.Random.Default.nextInt

class ArithmeticService : Service() {

    private val binder: IBinder = MyBinder(this)

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        calculateAndBroadcast()
        stopSelf()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun calculateAndBroadcast() {

        val valueToSend = nextInt(25) * nextInt(25)

        Intent().also { intent ->
            intent.action = "com.example.androidknowledge_dunets_l9.broadcast.NUMBER"
            intent.putExtra("result", valueToSend)
            sendBroadcast(intent)
        }
    }
}

class MyBinder(val servc: ArithmeticService): Binder() {
    fun getService(): ArithmeticService {
        return servc
    }
}