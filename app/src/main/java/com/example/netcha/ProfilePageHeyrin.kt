package com.example.netcha

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ProfilePageHeyrin : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_heyrin)

        val back = findViewById<ImageView>(R.id.mypage_image_back)
        back.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_right_enter,R.anim.slide_right_exit)
        }
    }
}