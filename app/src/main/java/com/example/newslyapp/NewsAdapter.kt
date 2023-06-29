package com.example.newslyapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newslyapp.Models.NewsHeadlines

class NewsAdapter(val context: Context, val articles: List<NewsHeadlines>) :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var newsTitle = itemView.findViewById<TextView>(R.id.text_title)
        var newsSource = itemView.findViewById<TextView>(R.id.text_source)
        var imageHeadlines = itemView.findViewById<ImageView>(R.id.img_headline)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.headline_list_item,parent,false)
        return ArticleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size;
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.newsTitle.text = article.title
        holder.newsSource.text = article.source.name
        Glide.with(context).load(article.urlToImage).into(holder.imageHeadlines)


    }
}