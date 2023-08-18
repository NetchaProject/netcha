package com.example.netcha

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.NestedScrollView
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY

class Moviedetailpage1 : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail_page1)

        var image_preview = findViewById<ImageView>(R.id.detail_page_image_preview)
        var image_back = findViewById<ImageView>(R.id.detail_page_image_back)
        val viewMore = findViewById<TextView>(R.id.detail_page_text_viewMore)

        image_preview.setOnClickListener {
            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://tv.kakao.com/v/387596246"))
            startActivity(intent)
        }
        image_back.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_right_enter, R.anim.slide_right_exit)
        }
        viewMore.setOnClickListener {
            val movieSummary = getString(R.string.detialpage_summary_movie1)

            val movieDetailPopup = MovieDetailPopup(this, movieSummary)
            movieDetailPopup.show()
        }

    }
}

