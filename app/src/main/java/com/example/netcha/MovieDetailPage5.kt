package com.example.netcha

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MovieDetailPage5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail_page5)

        val movieUrl = findViewById<ImageView>(R.id.detail_page_image_preview)
        val viewMore = findViewById<TextView>(R.id.detail_page_text_viewMore)
        val back = findViewById<ImageView>(R.id.detail_page_image_back)

        back.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_right_enter,R.anim.slide_right_exit)
        }

        movieUrl.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://tv.naver.com/v/5707401"))
            startActivity(intent)
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        }

        viewMore.setOnClickListener {
            val movieSummary = getString(R.string.detail_page_summary_movie5)

            val movieDetailPopup = MovieDetailPopup(this, movieSummary)
            movieDetailPopup.show()
        }
    }
}