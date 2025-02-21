package com.example.drifthead

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import android.widget.VideoView
import androidx.recyclerview.widget.RecyclerView

class resultAdapter(var result: List<Result>, var context: Context): RecyclerView.Adapter<resultAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.resultListName)
        val link: TextView = view.findViewById(R.id.resultListScore)
        val number: TextView = view.findViewById(R.id.resultListNumber)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.result_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return result.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = result[position].title
        holder.link.text = result[position].link
        holder.number.text = result[position].number
    }


}