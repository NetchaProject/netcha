package com.example.netcha

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView

class MovieDetailPage1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail_page1)

        var image_sense = findViewById<ImageView>(R.id.detialpage1_img_famoussense)
        var image_preview = findViewById<ImageView>(R.id.detailpage1_image_preview1)
        var image_back = findViewById<ImageView>(R.id.detailpage1_btn_back)
        image_sense.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://movie.daum.net/moviedb/main?movieId=111293"))
            startActivity(intent)
        }
        image_preview.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://tv.kakao.com/v/387596246"))
            startActivity(intent)
        }
       image_back.setOnClickListener {
            finish()
        }

    }
}

