package com.example.netcha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Mypage_jina : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_jina)

        val back_mypage = findViewById<ImageView>(R.id.back_mypage)
        back_mypage.setOnClickListener {
            finish()
        }

    }
}