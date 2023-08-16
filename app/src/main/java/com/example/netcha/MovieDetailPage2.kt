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

        val image_sense = findViewById<ImageView>(R.id.famous_sense_img_hangover3)
        var image_preview = findViewById<ImageView>(R.id.detailpage_image_preview1)
        image_sense.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://movie.daum.net/moviedb/main?movieId=111293"))
            startActivity(intent)
        }
        image_preview.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=SEUyEpGHcsA&t=2s"))
            startActivity(intent)
        }
    }
}