package com.example.newslyapp

import com.example.newslyapp.Models.NewsApiResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://newsapi.org/"
const val API_KEY = "7f4214a38e6445629f523fc0d41d18fb"

interface NewsInterface {

    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getHeadLines(@Query("country")country: String, @Query("page")page : Int) : Call<NewsApiResponse>

    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getTechHeadLines(@Query("country")country: String, @Query("page")page : Int, @Query("category")category : String ="technology") : Call<NewsApiResponse>

    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getBusinessHeadLines(@Query("country")country: String, @Query("page")page : Int, @Query("category")category : String ="business") : Call<NewsApiResponse>

    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getEntertainmentHeadLines(@Query("country")country: String, @Query("page")page : Int, @Query("category")category : String = "entertainment") : Call<NewsApiResponse>

    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getSportsHeadLines(@Query("country")country: String, @Query("page")page : Int, @Query("category")category : String ="sports") : Call<NewsApiResponse>

    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getScienceHeadLines(@Query("country")country: String, @Query("page")page : Int, @Query("category")category : String ="science") : Call<NewsApiResponse>


    @GET("v2/top-headlines?apiKey=${API_KEY}")
    fun getHealthHeadlines(@Query("country")country: String, @Query("page")page : Int, @Query("category")category : String ="health") : Call<NewsApiResponse>
}

object NewsService{
    val newsInstance : NewsInterface
    init{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retrofit.create(NewsInterface::class.java)
    }
}