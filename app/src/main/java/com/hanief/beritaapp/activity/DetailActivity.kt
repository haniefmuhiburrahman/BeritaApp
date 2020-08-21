package com.hanief.beritaapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hanief.beritaapp.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val title = intent.getStringExtra("title")
        val author = intent.getStringExtra("author")
        val description = intent.getStringExtra("description")
        val photo = intent.getStringExtra("photo")

        tv_title_detail.text = title
        tv_author_detail.text = author
        tv_description.text = description

        Glide.with(this).load(photo).into(iv_photo_detail)
    }
}
