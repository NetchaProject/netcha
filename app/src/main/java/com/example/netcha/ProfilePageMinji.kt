package com.example.netcha

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class ProfilePageMinji : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_minji)

        val back_mypage = findViewById<ImageView>(R.id.back_mypage)
        back_mypage.setOnClickListener {
            finish()
        }
    }
}