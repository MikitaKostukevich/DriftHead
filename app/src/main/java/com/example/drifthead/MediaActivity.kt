package com.example.drifthead

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale


class MediaActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var buttonRu: Button
    private lateinit var buttonEn: Button

    private lateinit var switchTheme: Switch
    private lateinit var buttonCalendar: Button
    private lateinit var buttonNews: Button
    private lateinit var buttonPilots: Button
    private lateinit var buttonResult: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        switchTheme = findViewById(R.id.switchTheme)
        buttonCalendar = findViewById(R.id.buttonCalendar)
        buttonNews = findViewById(R.id.buttonNews)
        buttonPilots = findViewById(R.id.buttonPilots)
        buttonResult = findViewById(R.id.buttonResult)

        switchTheme.setOnCheckedChangeListener(this)

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

        val mediaList: RecyclerView = findViewById(R.id.mediaList)
        val medias = listOf(


            Media(1, "photoone", getString(R.string.photoone), "https://www.youtube.com/live/7uXI49rgB1I?si=Dco2gMopFkYxRpZC"),
            Media(2, "phototwo", getString(R.string.phototwo), "https://youtu.be/XVVEs8uLxSM?si=s-AS8phf-XEPEixG"),
            Media(3, "photothree", getString(R.string.photothree), "https://www.youtube.com/watch?v=v9MwZWGPaCs"),
            Media(4, "photofour", getString(R.string.photofour), "https://www.youtube.com/watch?v=etIBzu2o7Uc"),
            Media(5, "photofive", getString(R.string.photofive), "https://www.youtube.com/watch?v=saVlj0F69aM")
        )

        mediaList.layoutManager = LinearLayoutManager(this)
        mediaList.adapter = MediaAdapter(medias, this)


        val buttons = mapOf(
            R.id.buttonPilots to ItemsActivity::class.java,
            R.id.buttonNews to NewsActivity::class.java,
            R.id.buttonResult to ResultActivity::class.java,
            R.id.buttonCalendar to CalendarActivity::class.java
        )

        buttons.forEach { (buttonId, activityClass) ->
            findViewById<Button>(buttonId).setOnClickListener {
                val intent = Intent(this, activityClass)
                startActivity(intent)
            }
        }

    }

    private fun saveThemeState(isDarkTheme: Boolean) {
        val sharedPreferences = getSharedPreferences("ThemePref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putBoolean("isDarkTheme", isDarkTheme)
        editor.apply()
    }

    override fun onResume() {
        super.onResume()

        val textColor = if (switchTheme.isChecked) R.color.white else R.color.black
        buttonCalendar.setTextColor(ContextCompat.getColor(this, textColor))
        buttonNews.setTextColor(ContextCompat.getColor(this, textColor))
        buttonPilots.setTextColor(ContextCompat.getColor(this, textColor))
        buttonResult.setTextColor(ContextCompat.getColor(this, textColor))
        buttonEn.setTextColor(ContextCompat.getColor(this, textColor))
        buttonRu.setTextColor(ContextCompat.getColor(this, textColor))
    }


    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {
        if (isChecked) {
            setTheme(R.style.MyDarkTheme)
            saveThemeState(true)
        } else {
            setTheme(R.style.MyLightTheme)
            saveThemeState(false)
        }
        val textColor = if (switchTheme.isChecked) R.color.white else R.color.black
        buttonCalendar.setTextColor(ContextCompat.getColor(this, textColor))
        buttonCalendar.setBackgroundColor(
            ContextCompat.getColor(
                this,
                if (isChecked) R.color.button_dark_background else R.color.button_light_background
            )
        )

        buttonNews.setTextColor(ContextCompat.getColor(this, textColor))
        buttonNews.setBackgroundColor(
            ContextCompat.getColor(
                this,
                if (isChecked) R.color.button_dark_background else R.color.button_light_background
            )
        )

        buttonPilots.setTextColor(ContextCompat.getColor(this, textColor))
        buttonPilots.setBackgroundColor(
            ContextCompat.getColor(
                this,
                if (isChecked) R.color.button_dark_background else R.color.button_light_background
            )
        )

        buttonResult.setTextColor(ContextCompat.getColor(this, textColor))
        buttonResult.setBackgroundColor(
            ContextCompat.getColor(
                this,
                if (isChecked) R.color.button_dark_background else R.color.button_light_background
            )
        )

        buttonEn.setTextColor(ContextCompat.getColor(this, textColor))
        buttonEn.setBackgroundColor(
            ContextCompat.getColor(
                this,
                if (isChecked) R.color.button_dark_background else R.color.button_light_background
            )
        )

        buttonRu.setTextColor(ContextCompat.getColor(this, textColor))
        buttonRu.setBackgroundColor(
            ContextCompat.getColor(
                this,
                if (isChecked) R.color.button_dark_background else R.color.button_light_background
            )
        )


    }
}