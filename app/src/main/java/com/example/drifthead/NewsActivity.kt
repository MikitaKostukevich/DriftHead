package com.example.drifthead

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale


class NewsActivity : AppCompatActivity() {

    private lateinit var buttonRu: Button
    private lateinit var buttonEn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        buttonRu = findViewById(R.id.buttonRu)
        buttonEn = findViewById(R.id.buttonEn)

        buttonRu.setOnClickListener {
            val locale = Locale("ru")
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

            recreate()
        }

        buttonEn.setOnClickListener {
            val locale = Locale("en")
            Locale.setDefault(locale)
            val config = Configuration()
            config.locale = locale
            baseContext.resources.updateConfiguration(config, baseContext.resources.displayMetrics)

            recreate()
        }

        val newsList: RecyclerView = findViewById(R.id.newsList)
        val news = listOf(
            News(1, "driftweekend", getString(R.string.driftweekend), "https://av.by/news/4_etap_betera_chempionat_po_driftingu_fotootchet"),
            News(2, "driftinpro", getString(R.string.driftinpro), "https://abw.by/news/autosport/2023/09/12/smena-lidera-i-kvalifikaciya-na-vybyvanie-drift-v-klasse-pro"),
            News(3, "fourstage", getString(R.string.fourstage), "https://av.by/news/driftzarya-v-staykakh"),
            News(4, "driftzarya", getString(R.string.driftzarya), "https://abw.by/news/autosport/2023/09/06/dvoinoi-drift-v-staikah--uzhe-v-eti-vyhodnye"),
            News(5, "zaryaone", getString(R.string.zaryaone), "https://av.by/news/driftzarya_2023_anons")
        )


        newsList.layoutManager = LinearLayoutManager(this)
        newsList.adapter = NewsAdapter(news, this)

        val buttons = mapOf(
            R.id.buttonPilots to ItemsActivity::class.java,
            R.id.buttonResult to ResultActivity::class.java,
            R.id.buttonMedia to MediaActivity::class.java,
            R.id.buttonCalendar to CalendarActivity::class.java
        )

        buttons.forEach { (buttonId, activityClass) ->
            findViewById<Button>(buttonId).setOnClickListener {
                val intent = Intent(this, activityClass)
                startActivity(intent)
            }
        }

    }
}