package com.example.netcha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        val tvMovie1: TextView = findViewById(R.id.tv_movie1)
        val btnSummary1: Button = findViewById(R.id.btn_summary1)

        val originalMaxLines = tvMovie1.maxLines
        val expandedMaxLines = Int.MAX_VALUE

        btnSummary1.setOnClickListener(object : View.OnClickListener {
            var isExpanded = false
            override fun onClick(p0: View?) {
                isExpanded = !isExpanded
                if (isExpanded) {
                    tvMovie1.maxLines = expandedMaxLines
                    btnSummary1.text = "접기"
                } else {
                    tvMovie1.maxLines = originalMaxLines
                    btnSummary1.text = "더보기"
                }
            }
        })
    }
}