package com.example.netcha

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity


class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this,SignInActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_down_enter,R.anim.slide_down_exit)
            finish()
        }, 1500)
    }
}