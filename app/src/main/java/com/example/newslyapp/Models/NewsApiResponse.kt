package com.example.newslyapp.Models

data class NewsApiResponse(
    val status: String ,
    val totalResults : Int,
    val articles : List<NewsHeadlines>,
)
