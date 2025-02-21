package com.example.drifthead

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class Result2021 : AppCompatActivity() {

    private lateinit var buttonRu: Button
    private lateinit var buttonEn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2021)

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
            Result(1, "1", getString(R.string.Roma_full_name), "337 pts"),
            Result(2, "2", getString(R.string.Kolya_full_name), "273 pts"),
            Result(3, "3", getString(R.string.Sak_full_name), "228 pts"),
            Result(4, "4", getString(R.string.Gedeminas_full_name), "225 pts"),
            Result(5, "5", getString(R.string.Cirba_full_name), "170 pts"),
            Result(6, "6", getString(R.string.Denis_full_name), "151 pts"),
            Result(7, "7", getString(R.string.Vlad_full_name), "144 pts"),
            Result(8, "8", getString(R.string.Valera_full_name), "133 pts"),
            Result(9, "9", getString(R.string.Artur_full_name), "126 pts"),
            Result(10, "10", getString(R.string.Vitaliy_full_name), "110 pts"),
            Result(11, "11", getString(R.string.Rostic_full_name), "104 pts"),
            Result(12, "12", getString(R.string.Czar_full_name), "94 pts"),
            Result(13, "13", getString(R.string.Gavrilenko_full_name),"77 pts"),
            Result(14, "14", getString(R.string.Anton_full_name), "74 pts"),
            Result(15, "15", getString(R.string.Vova_full_name), "69 pts"),
            Result(16, "16", "Zabulionis Giedrius", "69 pts"),
            Result(17, "17", getString(R.string.Lexa_full_name), "54 pts"),
            Result(18, "18", "Bieliauskas Silvetras", "39 pts"),
            Result(19, "19", getString(R.string.Vlasovec_full_name), "37 pts"),
            Result(20, "20", getString(R.string.Skuratov_full_name), "30 pts"),
            Result(21, "21", "Bertans Nikolass", "22 pts"),
            Result(22, "22", getString(R.string.Pavel_full_name), "19 pts"),
            Result(23, "23", getString(R.string.Andrey_full_name), "13 pts"),
            Result(24, "24", getString(R.string.Spsenisin_full_name), "13 pts"),
            Result(25, "25", getString(R.string.Timoscyk_full_name), "12 pts"),
            Result(26, "26", getString(R.string.Borya_full_name), "11 pts"),
            Result(27, "27", getString(R.string.Drift_full_name), "11 pts"),
            Result(28, "28", getString(R.string.Andreev_full_name), "2 pts"),
            Result(29, "29", getString(R.string.Shaskov_full_name), "2 pts"),
            Result(30, "30", getString(R.string.Turevich_full_name), "2 pts"),
            Result(31, "31", getString(R.string.Evgeniy_full_name), "1 pts"),
            Result(32, "32", "Kilbovskis Edgaras", "1 pts"),
            Result(33, "33", getString(R.string.Panglish_full_name), "1 pts"),
            Result(34, "34", getString(R.string.Augustovich_full_name), "1 pts"),
            Result(35, "35", getString(R.string.Rak_full_name), "1 pts"),
            Result(36, "36", getString(R.string.Lobkov_full_name), "1 pts"),
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