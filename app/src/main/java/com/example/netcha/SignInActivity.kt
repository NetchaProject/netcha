package com.example.netcha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val btnSignIn : Button = findViewById(R.id.btn_signin)
        val btnSignUp : Button = findViewById(R.id.btn_signup)


        btnSignIn.setOnClickListener {
            val intent = Intent(this,MainPage::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter,R.anim.slide_right_exit)
        }

        btnSignUp.setOnClickListener {

            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}