package com.example.drifthead

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class Result2022 : AppCompatActivity() {

    private lateinit var buttonRu: Button
    private lateinit var buttonEn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2022)

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

        val resultList: RecyclerView = findViewById(R.id.resultList)

        val result = listOf(
            Result(1, "1", getString(R.string.Roma_full_name), "489 pts"),
            Result(2, "2", getString(R.string.Denis_full_name), "416 pts"),
            Result(3, "3", getString(R.string.Anton_full_name), "371 pts"),
            Result(4, "4", getString(R.string.Vlad_full_name), "339 pts"),
            Result(5, "5", getString(R.string.Evgeniy_full_name), "234 pts"),
            Result(6, "6", getString(R.string.Pavel_full_name), "213 pts"),
            Result(7, "7", getString(R.string.Vova_full_name), "197 pts"),
            Result(8, "8", getString(R.string.Lexa_full_name), "158 pts"),
            Result(9, "9", getString(R.string.Vitaliy_full_name), "139 pts"),
            Result(10, "10", getString(R.string.Kolya_full_name), "75 pts"),
            Result(11, "11", getString(R.string.Spsenisin_full_name), "55 pts"),
            Result(12, "12", getString(R.string.Gorkovenko_full_name), "52 pts"),
            Result(13, "13", getString(R.string.Karelin_full_name), "52 pts"),
            Result(14, "14", getString(R.string.Vishnya_full_name), "52 pts"),
            Result(15, "15", getString(R.string.Pak_full_name), "19 pts"),
            Result(16, "16", getString(R.string.Borya_full_name), "0 pts"),
            Result(17, "17", getString(R.string.Dsesyz_full_name), "0 pts"),
            Result(18, "18", getString(R.string.Pozdnyakov_full_name), "0 pts"),
        )

        resultList.layoutManager = LinearLayoutManager(this)
        resultList.adapter = resultAdapter(result, this)


        val buttons = mapOf(
            R.id.buttonPilots to ItemsActivity::class.java,
            R.id.buttonNews to NewsActivity::class.java,
            R.id.buttonMedia to MediaActivity::class.java,
            R.id.buttonCalendar to CalendarActivity::class.java,
            R.id.button2023 to ResultActivity::class.java,
            R.id.button2022 to Result2022::class.java,
            R.id.button2021 to Result2021::class.java
        )

        buttons.forEach { (buttonId, activityClass) ->
            findViewById<Button>(buttonId).setOnClickListener {
                val intent = Intent(this, activityClass)
                startActivity(intent)
            }
        }
    }
}