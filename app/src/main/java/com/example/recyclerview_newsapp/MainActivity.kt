package com.example.recyclerview_newsapp

import MyAdapter
import News
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), MyAdapter.setOnItemClickListner {
    lateinit var myRecyclerView :RecyclerView
    lateinit var newsArrayList : ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        myRecyclerView = findViewById(R.id.recyclerView )
        var newsImageArray = arrayOf(
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6,
        )
        var newsHeading = arrayOf(
            "U.K. Foreign Secretary James Cleverly raises issue of BBC tax searches with EAM Jaishankar",
            "Cooking gas prices hiked by ₹50 for domestic, ₹350.50 for commercial cylinders",
            "Joe Biden appoints two prominent Indian-American corporate leaders to his Export Council",
            "Sergey Lavrov will raise suspected bombing of Nord Stream II at G20: Russian Foreign Ministry",
            "Belarusian leader Lukashenko visits China amid Ukraine tensions",
            "China rips new U.S. House committee on countering Beijing",

        )
        val newsContent = arrayOf(getString(R.string.news),getString(R.string.news),getString(R.string.news),getString(R.string.news),getString(R.string.news),getString(R.string.news))
        // ye set krta hai ki recycler view ke andr jo item hote hai unka hav bhav kaise hoga
        // jaise ki virtically scrolling , horizontally scrolling , unifrom grid aise sb setting honge usme

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()
        for(everyindex in newsImageArray.indices){
            val news = News(newsHeading[everyindex], newsImageArray[everyindex] , newsContent[everyindex])
            newsArrayList.add(news)
        }
        myRecyclerView.adapter = MyAdapter(newsArrayList,this,this)
    }

    override fun onItemClicked(ArrayList: News , position:Int )  {
       val intent = Intent(this@MainActivity,NewsDetailActivity::class.java)
    intent.putExtra("heading",newsArrayList[position].newsHeading)
    intent.putExtra("image",newsArrayList[position].newsImage)
    intent.putExtra("content",newsArrayList[position].newsContent)
        startActivity(intent)
}
}