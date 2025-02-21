package com.example.drifthead

import PilotAdapter
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import androidx.core.content.ContextCompat
import java.util.Locale

class ItemsActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var buttonRu: Button
    private lateinit var buttonEn: Button

    private lateinit var switchTheme: Switch
    private lateinit var buttonCalendar: Button
    private lateinit var buttonNews: Button
    private lateinit var buttonMedia: Button
    private lateinit var buttonResult: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        switchTheme = findViewById(R.id.switchTheme)
        buttonCalendar = findViewById(R.id.buttonCalendar)
        buttonNews = findViewById(R.id.buttonNews)
        buttonMedia = findViewById(R.id.buttonMedia)
        buttonResult = findViewById(R.id.buttonResult)

        switchTheme.setOnCheckedChangeListener(this)

        buttonRu = findViewById(R.id.buttonRu)
        buttonEn = findViewById(R.id.buttonEn)

        val pilotList: RecyclerView = findViewById(R.id.itemsList)
        val pilots = arrayListOf<Pilot>()

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

        pilots.add(
            Pilot(
                1,
                "roman",
                getString(R.string.Roma_full_name),
                getString(R.string.Roma_place),
                getString(R.string.Roma_dateOfBirth),
                "ЭТА Моторспорт",
                getString(R.string.Roma_text),
                "BMW M2 Competition, 2JZ, 3.0, 600 h.p. | Nissan S13, 1JZ, 600 h.p.",
                "https://www.instagram.com/dikijdrifter/"
            )
        )
        pilots.add(
            Pilot(
                2,
                "denis",
                getString(R.string.Denis_full_name),
                getString(R.string.Denis_place),
                getString(R.string.Denis_dateOfBirth),
                "-",
                getString(R.string.Denis_text),
                "Nissan 200SX, 2JZ, 3.0, 650 h/p.",
                "https://www.instagram.com/denis_klischevskiy/"
            )
        )
        pilots.add(
            Pilot(
                3,
                "anton",
                getString(R.string.Anton_full_name),
                getString(R.string.Anton_place),
                getString(R.string.Anton_dateOfBirth),
                "Tony Motors",
                getString(R.string.Anton_text),
                "Nissan S13, 2JZ-GE, 3.0, 500 h.p.",
                "https://www.instagram.com/tony_drives/"
            )
        )
        pilots.add(
            Pilot(
                4,
                "vlad",
                getString(R.string.Vlad_full_name),
                getString(R.string.Vlad_place),
                getString(R.string.Vlad_dateOfBirth),
                "-",
                getString(R.string.Vlad_text),
                "Nissan S15, 2JZ, 3.0, 700 h.p.",
                "https://www.instagram.com/vladislav_shubaderov/"
            )
        )
        pilots.add(
            Pilot(
                5,
                "evgeniy",
                getString(R.string.Evgeniy_full_name),
                getString(R.string.Evgeniy_place),
                getString(R.string.Evgeniy_dateOfBirth),
                "Adrenalin Drift Team",
                getString(R.string.Evgeniy_text),
                "BMW E46, 2.8, 500 h.p.",
                "https://www.instagram.com/evgenii.milinchuk/"
            )
        )
        pilots.add(
            Pilot(
                6,
                "pavel",
                getString(R.string.Pavel_full_name),
                getString(R.string.Pavel_place),
                getString(R.string.Pavel_dateOfBirth),
                "ЭТА Моторспорт",
                getString(R.string.Pavel_text),
                "BMW E30, 2JZ, 3.0, 450 h.p.",
                "https://www.instagram.com/kapshai/"
            )
        )
        pilots.add(
            Pilot(
                7,
                "vova",
                getString(R.string.Vova_full_name),
                getString(R.string.Vova_place),
                getString(R.string.Vova_dateOfBirth),
                "Adrenalin Drift Team",
                getString(R.string.Vova_text),
                "Nissan Silvia 80, 1JZ, 490 h.p. /BMW 320 E46, 1JZ, 500 h.p.",
                ""
            )
        )
        pilots.add(
            Pilot(
                8,
                "lexa",
                getString(R.string.Lexa_full_name),
                getString(R.string.Lexa_place),
                getString(R.string.Lexa_dateOfBirth),
                "-",
                getString(R.string.Lexa_text),
                "Nissan 200SX, 2JZ, 3.0, 560 h.p.",
                "https://www.instagram.com/kashal0t/"
            )
        )
        pilots.add(
            Pilot(
                9,
                "vitaliy",
                getString(R.string.Vitaliy_full_name),
                getString(R.string.Vitaliy_place),
                getString(R.string.Vitaliy_dateOfBirth),
                "Школа дрифта JP Day",
                getString(R.string.Vitaliy_text),
                "Nissan 200SX, LS, 5.7, 460 h.p.",
                "https://www.instagram.com/vitalisilivonchyk/"
            )
        )
        pilots.add(
            Pilot(
                10,
                "kolya",
                getString(R.string.Kolya_full_name),
                getString(R.string.Kolya_place),
                getString(R.string.Kolya_dateOfBirth),
                "Black Star PENGUIN",
                getString(R.string.Kolya_text),
                "Nissan 200SX S14.5, LS3 Supercgharger, 6.2, 650 h.p.",
                "https://www.instagram.com/litvinz/"
            )
        )
        pilots.add(
            Pilot(
                11,
                "borya",
                getString(R.string.Borya_full_name),
                getString(R.string.Borya_place),
                getString(R.string.Borya_dateOfBirth),
                "korCHEDrift",
                getString(R.string.Borya_text),
                "BMW E36, M60B40 Turbo, 4.0, 430 h.p.",
                "https://www.instagram.com/korchedrift/"
            )
        )
        pilots.add(
            Pilot(
                12,
                "sak",
                getString(R.string.Sak_full_name),
                getString(R.string.Sak_place),
                getString(R.string.Sak_dateOfBirth),
                "G-Drive",
                getString(R.string.Sak_text),
                "Nissan 350Z, 5.6, 420 h.p.",
                "https://www.instagram.com/sergei_sak/"
            )
        )
        pilots.add(
            Pilot(
                13,
                "gedeminas",
                getString(R.string.Gedeminas_full_name),
                getString(R.string.Gedeminas_place),
                getString(R.string.Gedeminas_dateOfBirth),
                "Side to Side & Urta drift team",
                getString(R.string.Gedeminas_text),
                "Nissan Silvia S14, 2JZ, 3.0, 500 h.p.",
                "https://www.instagram.com/levickasgediminas/"
            )
        )
        pilots.add(
            Pilot(
                14,
                "cirba",
                getString(R.string.Cirba_full_name),
                getString(R.string.Cirba_place),
                getString(R.string.Cirba_dateOfBirth),
                "Side to Side & Urta drift team",
                getString(R.string.Cirba_text),
                "BMW E92, 950 h.p.",
                "https://www.instagram.com/benediktascirba/"
            )
        )
        pilots.add(
            Pilot(
                15,
                "valera",
                getString(R.string.Valera_full_name),
                getString(R.string.Valera_place),
                getString(R.string.Valera_dateOfBirth),
                "-",
                getString(R.string.Valera_text),
                "Nissan Silvia S14, 2JZ, 3.0, 500 h.p.",
                "https://www.instagram.com/valeriy.shevelev/"
            )
        )
        pilots.add(
            Pilot(
                16,
                "artur",
                getString(R.string.Artur_full_name),
                getString(R.string.Artur_place),
                getString(R.string.Artur_dateOfBirth),
                "-",
                getString(R.string.Artur_text),
                "Toyota GT86, 2JZ, 3.0, 800 h.p.",
                "https://www.instagram.com/artur.podluzhnyi/"
            )
        )
        pilots.add(
            Pilot(
                17,
                "rostic",
                getString(R.string.Rostic_full_name),
                getString(R.string.Rostic_place),
                getString(R.string.Rostic_dateOfBirth),
                "-",
                getString(R.string.Rostic_text),
                "Toyota GT86, 2JZ GTE, 3.4, 1116 h.p.",
                "https://www.instagram.com/rarahovskyi_/"
            )
        )
        pilots.add(
            Pilot(
                18,
                "czar",
                getString(R.string.Czar_full_name),
                getString(R.string.Czar_place),
                getString(R.string.Czar_dateOfBirth),
                "FailCwer Дарксайд",
                getString(R.string.Czar_text),
                "Nissan 370Z, VR38DETT, 3.8, 953 h.p.",
                "https://www.instagram.com/tsaregradtsev_ark/"
            )
        )
        pilots.add(
            Pilot(
                19,
                "andrey",
                getString(R.string.Andrey_full_name),
                getString(R.string.Andrey_place),
                getString(R.string.Andrey_dateOfBirth),
                "-",
                getString(R.string.Andrey_text),
                "BMW 320, LSX, 7.4, 600 h.p.",
                "https://www.instagram.com/piskarevteam/"
            )
        )
        pilots.add(
            Pilot(
                20,
                "ivanula",
                getString(R.string.Ivanula_full_name),
                getString(R.string.Ivanula_place),
                getString(R.string.Ivanula_dateOfBirth),
                "-",
                getString(R.string.Ivanula_text),
                "Nissan 180SX, 2JZ, 3.0, 850 h.p.",
                "https://www.instagram.com/ivanuledrift/"
            )
        )
        pilots.add(
            Pilot(
                21,
                "gocha",
                getString(R.string.Gocha_full_name),
                getString(R.string.Gocha_place),
                getString(R.string.Gocha_dateOfBirth),
                "ФОРВАРД АВТО",
                getString(R.string.Gocha_text),
                "Nissan GTR R-35, VR38, 3.8, 750 h.p.",
                "https://www.instagram.com/gocha_chivchyan/"
            )
        )
        pilots.add(
            Pilot(
                22,
                "nick",
                getString(R.string.Nick_full_name),
                getString(R.string.Nick_place),
                getString(R.string.Nick_dateOfBirth),
                "Carville Racing",
                getString(R.string.Nick_text),
                "Toyota Supra A90, 2JZ GTE, 3.4, 1013 h.p.",
                "https://www.instagram.com/shikov_nikita/"
            )
        )
        pilots.add(
            Pilot(
                23,
                "golalex",
                getString(R.string.Golalex_full_name),
                getString(R.string.Golalex_place),
                getString(R.string.Golalex_dateOfBirth),
                "LUKOIL Racing Drift Team",
                getString(R.string.Golalex_text),
                "Nissan S14, 2JZ, 3.0, 700 h.p.",
                "https://www.instagram.com/alexholovnia?igsh=dzlqdWtnb3lqcG54"
            )
        )
        pilots.add(
            Pilot(
                24,
                "nagula",
                getString(R.string.Legend_full_name),
                getString(R.string.Legend_place),
                getString(R.string.Legend_dateOfBirth),
                "Betera Drift Team",
                getString(R.string.Legend_text),
                "Nissan SX200, 2JZ, 3.0, 700 h.p.",
                "https://www.instagram.com/dimanagula/"
            )
        )

        pilotList.layoutManager = LinearLayoutManager(this)
        pilotList.adapter = PilotAdapter(pilots, this)

        val buttons = mapOf(
            R.id.buttonResult to ResultActivity::class.java,
            R.id.buttonNews to NewsActivity::class.java,
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