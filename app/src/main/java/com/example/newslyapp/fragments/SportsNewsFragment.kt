package com.example.newslyapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newslyapp.Models.NewsApiResponse
import com.example.newslyapp.NewsAdapter
import com.example.newslyapp.NewsService
import com.example.newslyapp.databinding.FragmentScienceNewsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SportsNewsFragment : Fragment() {

    private lateinit var binding: FragmentScienceNewsBinding
    private lateinit var adapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScienceNewsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the adapter with an empty list of articles
        adapter = NewsAdapter(requireContext(), emptyList())

        // Set the adapter to the RecyclerView
        binding.recyclerMain.adapter = adapter
        binding.recyclerMain.layoutManager = LinearLayoutManager(requireContext())

        // Call the function to fetch and update the news articles
        getNews()
    }

    private fun getNews() {
        lifecycleScope.launch(Dispatchers.Main) {
            try {
                val newsService = NewsService.newsInstance
                val response = withContext(Dispatchers.IO) {
                    newsService.getSportsHeadLines("in", 1,).execute()
                }
                if (response.isSuccessful) {
                    val newsApiResponse = response.body()
                    if (newsApiResponse != null) {
                        adapter.updateArticles(newsApiResponse.articles)
                    }
                } else {
                    Log.d("Error", "Unable to fetch news")
                }
            } catch (e: Exception) {
                Log.d("Error", "Exception occurred: ${e.message}")
            }
        }
    }

}
