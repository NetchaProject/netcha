package com.example.netcha

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar

class UserDataFind : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_data_find)

        val btn = findViewById<ImageView>(R.id.backbutton_user_data_find)
        btn.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        }
        
        }
      

        val userFindBtn = findViewById<Button>(R.id.user_find_btn_login)
        val userDataBase = UserDatabase

        userFindBtn.setOnClickListener {

            val editName = findViewById<EditText>(R.id.user_find_et_id)
            val foundName = userDataBase.findUserByName(editName.text.toString())
            val ivFail = findViewById<ImageView>(R.id.user_find_iv_fail)
            val tvFail = findViewById<TextView>(R.id.user_find_tv_fail)
            val idFind = findViewById<TextView>(R.id.user_find_tv_id)
            val pwFind = findViewById<TextView>(R.id.user_find_tv_pw)

            fun maskString(input: String, visibleChars: Int): String {
                val maskChar = '*'
                val maskedChars = input.take(visibleChars).padEnd(input.length, maskChar)
                return maskedChars
            }

            // 사용자 일치
            if (foundName != null) {
                idFind.visibility = View.VISIBLE
                pwFind.visibility = View.VISIBLE
                ivFail.visibility = View.INVISIBLE
                tvFail.visibility = View.INVISIBLE

                val maskedPW = maskString(foundName.pw, 3)

                idFind.text = "ID: ${foundName.id}"
                pwFind.text = "PW: $maskedPW"
            } else {
                idFind.visibility = View.INVISIBLE
                pwFind.visibility = View.INVISIBLE
                ivFail.visibility = View.VISIBLE
                tvFail.visibility = View.VISIBLE
            }
        }

    }
    }
}