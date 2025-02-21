package com.example.drifthead

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class CalendarActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var buttonRu: Button
    private lateinit var buttonEn: Button

    private lateinit var switchTheme: Switch
    private lateinit var buttonPilots: Button
    private lateinit var buttonNews: Button
    private lateinit var buttonMedia: Button
    private lateinit var buttonResult: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        switchTheme = findViewById(R.id.switchTheme)
        buttonPilots = findViewById(R.id.buttonPilots)
        buttonNews = findViewById(R.id.buttonNews)
        buttonMedia = findViewById(R.id.buttonMedia)
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

        val calendarList: RecyclerView = findViewById(R.id.calendarList)
        val calendar = listOf(
            Calendar(1, "driftraubichipromo", "#DriftRaubich23",  getString(R.string.DriftRaubich23_Name), getString(R.string.DriftRaubich23_Date), getString(R.string.DriftRaubich23_Place), "https://maps.app.goo.gl/WejyAZx1wGL7QjWs8"),
            Calendar(2, "driftstaykipromo", "#DriftStayki23", getString(R.string.DriftStayki23_Name), getString(R.string.DriftStayki23_Date), getString(R.string.DriftStayki23_Place), "https://maps.app.goo.gl/pMBjQKymU4WwEWMy6"),
            Calendar(3, "driftlogoiskpromo", "#DriftLogoisk23", getString(R.string.DriftLogoisk23_Name), getString(R.string.DriftLogoisk23_Date), getString(R.string.DriftLogoisk23_Place), "https://maps.app.goo.gl/Pxpm4tbnFszQuP6VA"),
            Calendar(4, "driftzaryapromo", "#DriftZarya23", getString(R.string.DriftZarya23_Name), getString(R.string.DriftZarya23_Date), getString(R.string.DriftZarya23_Place), "https://maps.app.goo.gl/GcvLBP6j3FwWJ3E7A")
        )

        calendarList.layoutManager = LinearLayoutManager(this)
        calendarList.adapter = CalendarAdapter(calendar, this)


        val buttons = mapOf(
            R.id.buttonPilots to ItemsActivity::class.java,
            R.id.buttonNews to NewsActivity::class.java,
            R.id.buttonMedia to MediaActivity::class.java,
            R.id.buttonResult to ResultActivity::class.java
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
        buttonPilots.setTextColor(ContextCompat.getColor(this, textColor))
        buttonNews.setTextColor(ContextCompat.getColor(this, textColor))
        buttonMedia.setTextColor(ContextCompat.getColor(this, textColor))
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
        buttonPilots.setTextColor(ContextCompat.getColor(this, textColor))
        buttonPilots.setBackgroundColor(
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

        buttonMedia.setTextColor(ContextCompat.getColor(this, textColor))
        buttonMedia.setBackgroundColor(
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