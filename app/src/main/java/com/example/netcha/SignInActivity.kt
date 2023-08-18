package com.example.netcha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    lateinit var etLogin: EditText
    lateinit var  etPw: EditText
    lateinit var tvFail: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val btnSignIn: Button = findViewById(R.id.sign_in_btn_login)
        val btnSignUp: Button = findViewById(R.id.sign_in_btn_join)
        val btnSignFind: Button = findViewById(R.id.sign_in_btn_find)
        etLogin = findViewById(R.id.sign_in_et_id)
        etPw = findViewById(R.id.sign_in_et_pw)
        tvFail = findViewById(R.id.sign_in_tv_fail)
        btnSignIn.setOnClickListener {
            validation()
        }

        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            initValue()
        }

        btnSignFind.setOnClickListener {
            val intent = Intent(this, UserDataFind::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            initValue()
        }
    }

    fun initValue() {
        tvFail.visibility = View.INVISIBLE
        etLogin.text = null
        etPw.text = null
    }
    fun validation(){
        UserDatabase.addUser("test", "1", "1")
        val data = UserDatabase.findUserValidation(etLogin.text.toString(), etPw.text.toString())
        if(data?.id == etLogin.text.toString() && data?.pw == etPw.text.toString() && !etLogin.text.toString().trim().isEmpty() && !etPw.text.toString().trim().isEmpty()){
            val intent = Intent(this, MainPage::class.java)
            intent.putExtra("nickname", data?.name)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
            initValue()
        }else if (etLogin.text.toString().trim().isEmpty() && etPw.text.toString().trim().isEmpty()){
            tvFail.visibility = View.INVISIBLE
        }else{
            tvFail.visibility = View.VISIBLE
        }
    }
}