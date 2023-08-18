package com.example.netcha

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MovieDetailPage3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail_page3)


        var image_preview = findViewById<ImageView>(R.id.detail_page_image_preview)
        var image_back = findViewById<ImageView>(R.id.detail_page_image_back)
        val viewMore = findViewById<TextView>(R.id.view_more)
        image_preview.setOnClickListener{
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://tv.kakao.com/v/80854967"))
            startActivity(intent)
        }
        image_back.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_right_enter,R.anim.slide_right_exit)
        }
        viewMore.setOnClickListener {
            val movieSummary = getString(R.string.detailpage_summary_movie2)

            val movieDetailPopup = MovieDetailPopup(this, movieSummary)
            movieDetailPopup.show()
        }
    }
}

