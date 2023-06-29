package com.example.newslyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newslyapp.Models.NewsApiResponse
import com.example.newslyapp.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getNews()

    }

    private fun getNews() {
        val news = NewsService.newsInstance.getHeadLines("us",1)
        news.enqueue(object : Callback<NewsApiResponse> {
            override fun onResponse(
                call: Call<NewsApiResponse>,
                response: Response<NewsApiResponse>
            ) {
                val news : NewsApiResponse? = response.body()
                if (news != null) {
                    var adapter = NewsAdapter(this@MainActivity, news.articles)
                    val newsList: RecyclerView = binding.recyclerMain
                    adapter = NewsAdapter(this@MainActivity, news.articles)
                    newsList.adapter = adapter
                    newsList.layoutManager = LinearLayoutManager(this@MainActivity)

                }
            }

            override fun onFailure(call: Call<NewsApiResponse>, t: Throwable) {
                Log.d("Error", "Unable to fetch news");
            }

        })
    }
}