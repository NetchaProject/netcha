package com.example.netcha

import android.app.Dialog
import android.content.Context
import android.widget.Button
import android.widget.TextView

class MovieDetailPopup(private val context: Context, private val movieSummary: String) {

    fun show() {
        val dialog = Dialog(context)
        dialog.setContentView(R.layout.detail_page_story_popup)

        val popupDetailStory = dialog.findViewById<TextView>(R.id.detail_page_text_detailStory)
        val popupViewMore = dialog.findViewById<Button>(R.id.detail_page_btn_fold)

        popupDetailStory.text = movieSummary

        popupViewMore.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}