package com.example.androidknowledge_dunets_l9

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
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

        val valueToSend = nextInt(1, 26) * nextInt(1, 25)

        Intent().also { intent ->
            intent.action = SERVICE_ACTION
            intent.putExtra("result", valueToSend)
            sendBroadcast(intent)
        }
    }
}

class MyBinder(val servc: ArithmeticService) : Binder() {
    fun getService(): ArithmeticService {
        return servc
    }
}