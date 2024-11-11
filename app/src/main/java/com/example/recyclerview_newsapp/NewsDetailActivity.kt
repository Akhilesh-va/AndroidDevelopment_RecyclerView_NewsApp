package com.example.recyclerview_newsapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_news_detail)
        val heading = intent.getStringExtra("heading")
        val image = intent.getIntExtra("image",R.drawable.img1)
        val content = intent.getStringExtra("content",)
        val newsHeading = findViewById<TextView>(R.id.newsHeading)
        val newsImage = findViewById<ImageView>(R.id.newsImage)
        val newsContent = findViewById<TextView>(R.id.newsContent)
        newsHeading.text=heading
        newsContent.text=content
        newsImage.setImageResource(image)


    }
}