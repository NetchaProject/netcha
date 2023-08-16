package com.example.netcha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class sign_in : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in)

        val btn = findViewById<Button>(R.id.btn_signup)

        btn.setOnClickListener{

            val intent = Intent(this, sign_up::class.java)
            startActivity(intent)

        }

    }
}