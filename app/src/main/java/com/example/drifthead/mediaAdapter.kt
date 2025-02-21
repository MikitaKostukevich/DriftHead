package com.example.drifthead

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MediaAdapter(private var medias: List<Media>, private var context: Context) :
    RecyclerView.Adapter<MediaAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.mediaListImage)
        val title: TextView = view.findViewById(R.id.mediaListTitle)
        val link: TextView = view.findViewById(R.id.mediaListLink)

        init {
            image.setOnClickListener {
                val mediaItem = medias[adapterPosition]
                val uri = Uri.parse(mediaItem.link)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.media_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return medias.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = medias[position].title
        holder.link.text = medias[position].link

        val imageId = context.resources.getIdentifier(
            medias[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)
    }
}
