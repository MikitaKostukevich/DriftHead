import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.drifthead.Pilot
import com.example.drifthead.R

class PilotAdapter(private var pilots: List<Pilot>, private var context: Context) :
    RecyclerView.Adapter<PilotAdapter.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.pilotListImage)
        val title: TextView = view.findViewById(R.id.pilotListTitle)
        val place: TextView = view.findViewById(R.id.pilotListPlace)
        val dateOfBirth: TextView = view.findViewById(R.id.pilotListDateOfBirth)
        val comand: TextView = view.findViewById(R.id.pilotListComand)
        val text: TextView = view.findViewById(R.id.pilotListText)
        val link: TextView = view.findViewById(R.id.pilotListLink)
        val auto: TextView = view.findViewById(R.id.pilotListAuto)

        init {
            image.setOnClickListener {
                val pilotItem = pilots[adapterPosition]
                // Замените "YourActivity" на вашу активность, из которой будет открываться ссылка
                val uri = Uri.parse(pilotItem.link)
                val intent = Intent(Intent.ACTION_VIEW, uri)
                context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pilot_in_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pilots.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = pilots[position].title
        holder.place.text = pilots[position].place
        holder.dateOfBirth.text = pilots[position].dateOfBirth
        holder.comand.text = pilots[position].comand
        holder.text.text = pilots[position].text
        holder.auto.text = pilots[position].auto

        val imageId = context.resources.getIdentifier(
            pilots[position].image,
            "drawable",
            context.packageName
        )
        holder.image.setImageResource(imageId)
    }
}
