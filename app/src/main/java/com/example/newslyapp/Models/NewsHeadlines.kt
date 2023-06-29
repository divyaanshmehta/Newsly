package com.example.newslyapp.Models

data class NewsHeadlines(
    val source: NewsSource,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String
)