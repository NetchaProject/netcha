package com.example.netcha

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class sign_up : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_up)

        val btn = findViewById<Button>(R.id.btn_sing_up)
        btn.setOnClickListener {
            finish()
        }
        }
    }


