package com.example.alarmmanager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.CheckBox
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        handler = Handler()
        startMidnightreset()
    }
    private fun startMidnightreset(){
        handler.postDelayed({
            val currentTime = Calendar.getInstance()
            val currentHour = currentTime.get(Calendar.HOUR_OF_DAY)
            val currentMin = currentTime.get(Calendar.MINUTE)
            if(currentHour == 10 && currentMin == 47) {
                resetCheckboxes()
            }
            startMidnightreset()
            },6000)
        }
    private fun resetCheckboxes() {
        val checkBox = findViewById<CheckBox>(R.id.checkbox)
        checkBox.isChecked=true
    }
    }
