package com.example.breakingbadappnative.activities.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.breakingbadapp.R
import com.example.breakingbadapp.activities.main.MainActivity

class FirstMain : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        starTimer()
    }
    fun starTimer(){
        object : CountDownTimer(5000,5000){
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                val intent= Intent (applicationContext, MainActivity::class.java).apply {}
                startActivity(intent)}

        }.start()
}}