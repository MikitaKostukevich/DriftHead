package com.example.drifthead

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NewsAdapter(private var news: List<News>, private var context: Context) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.newsListImage)
        val title: TextView = view.findViewById(R.id.newsListTitle)
        val link: TextView = view.findViewById(R.id.newsListLink)

        init {
            image.setOnClickListener {
                val newsItem = news[adapterPosition]
                val uri = Uri.parse(newsItem.link)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.news_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = news[position].title
        holder.link.text = news[position].link

        val ImageId = context.resources.getIdentifier(
            news[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(ImageId)
    }
}
