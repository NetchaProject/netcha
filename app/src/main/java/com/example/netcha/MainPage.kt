package com.example.netcha

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        val btnLogout : ImageButton = findViewById(R.id.main_page_btn_logout)
        val imageViewList = listOf(
            findViewById<ImageView>(R.id.main_page_iv_profile1),
            findViewById<ImageView>(R.id.main_page_iv_profile2),
            findViewById<ImageView>(R.id.main_page_iv_profile3),
            findViewById<ImageView>(R.id.main_page_iv_profile4),
            findViewById<ImageView>(R.id.main_page_iv_profile5),
            findViewById<ImageView>(R.id.main_page_iv_movie1),
            findViewById<ImageView>(R.id.main_page_iv_movie2),
            findViewById<ImageView>(R.id.main_page_iv_movie3),
            findViewById<ImageView>(R.id.main_page_iv_movie4),
            findViewById<ImageView>(R.id.main_page_iv_movie5),
            findViewById<ImageView>(R.id.main_page_iv_movie6),
        )
        val imageViewMap = mapOf(
            R.id.main_page_iv_profile1 to ProfilePageHeyrin::class.java,
            R.id.main_page_iv_profile2 to ProfilePageJina::class.java,
            R.id.main_page_iv_profile3 to ProfilePageYongseok::class.java,
            R.id.main_page_iv_profile4 to ProfilePageMinji::class.java,
            R.id.main_page_iv_profile5 to ProfilePageDonghyun::class.java,
            R.id.main_page_iv_movie1 to MovieDetailPage1::class.java,
            R.id.main_page_iv_movie2 to MovieDetailPage2::class.java,
            R.id.main_page_iv_movie3 to MovieDetailPage3::class.java,
            R.id.main_page_iv_movie4 to MovieDetailPage4::class.java,
            R.id.main_page_iv_movie5 to MovieDetailPage5::class.java,
            R.id.main_page_iv_movie6 to MovieDetailPage6::class.java,
        )

        for(imageView in imageViewList){
            imageView.setOnClickListener {
                val targetClass = imageViewMap[it.id]
                targetClass?.let{
                    val intent = Intent(this, it)
                    startActivity(intent)
                    overridePendingTransition(R.anim.slide_left_enter,R.anim.slide_left_exit)
                }
            }
        }

        btnLogout.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("로그아웃 하시겠습니까?")
                .setNegativeButton("취소",
                DialogInterface.OnClickListener{ dialog, id ->

                })
                .setPositiveButton("확인",
                DialogInterface.OnClickListener { dialog, id ->
                    finish()
                    overridePendingTransition(R.anim.slide_right_enter,R.anim.slide_right_exit)
                })
            builder.show()
        }
    }
}