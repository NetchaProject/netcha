package com.example.netcha

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MovieDetailPage4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail_page4)

        val movieUrl = findViewById<ImageView>(R.id.url)
        val viewMore = findViewById<TextView>(R.id.view_more)
        val movieStory = findViewById<TextView>(R.id.movie_story_detail)
        val originalMaxLines = movieStory.maxLines
        val expandedMaxLines = Int.MAX_VALUE


        movieUrl.setOnClickListener {
            var intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("https://tv.naver.com/v/4747256"))
            startActivity(intent)
        }

        viewMore.setOnClickListener(object : View.OnClickListener {
            var isExpanded = false
            override fun onClick(p0: View?) {
                isExpanded = !isExpanded
                if (isExpanded) {
                    movieStory.maxLines = expandedMaxLines
                    viewMore.text = "접기"
                } else {
                    movieStory.maxLines = originalMaxLines
                    viewMore.text = "더보기"
                }
            }
        })


    }
}