package com.example.netcha

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MovieDetailPage2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail_page2)

        val image_sense = findViewById<ImageView>(R.id.detialpage2_img_famoussense)
        var image_preview = findViewById<ImageView>(R.id.detailpage2_image_preview1)
        var image_back = findViewById<ImageView>(R.id.detailpage2_btn_back)
        image_sense.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://movie.daum.net/moviedb/main?movieId=66593"))
            startActivity(intent)
        }
        image_preview.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://tv.kakao.com/v/48488770"))
            startActivity(intent)
        }
        image_back.setOnClickListener {
            finish()
        }
    }
}