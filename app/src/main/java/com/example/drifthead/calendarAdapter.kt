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

@Suppress("DEPRECATION")
class CalendarAdapter(private var calendars: List<Calendar>, private var context: Context) :
    RecyclerView.Adapter<CalendarAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.calendarListImage)
        val title: TextView = view.findViewById(R.id.calendarListTitle)
        val name: TextView = view.findViewById(R.id.calendarListName)
        val link: TextView = view.findViewById(R.id.calendarListLink)
        val date: TextView = view.findViewById(R.id.calendarListDate)
        val place: TextView = view.findViewById(R.id.calendarListPlace)

        init {
            image.setOnClickListener {
                val calendarItem = calendars[adapterPosition]
                val uri = Uri.parse(calendarItem.link)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.calendar_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return calendars.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = calendars[position].title
        holder.name.text = calendars[position].name
        holder.place.text = calendars[position].place
        holder.date.text = calendars[position].date
        holder.link.text = calendars[position].link

        val imageId = context.resources.getIdentifier(
            calendars[position].image,
            "drawable",
            context.packageName
        )

        holder.image.setImageResource(imageId)
    }
}
