package com.example.netcha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ProfilePageJina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_jina)

        val back_mypage = findViewById<ImageView>(R.id.mypage_image_back)
        back_mypage.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_right_enter,R.anim.slide_right_exit)
        }

    }
}