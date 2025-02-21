package com.example.drifthead

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Locale

class ResultActivity : AppCompatActivity() {

    private lateinit var buttonRu: Button
    private lateinit var buttonEn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

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
            Result(1, "1", getString(R.string.Vlad_full_name), "367 pts"),
            Result(2, "2", getString(R.string.Roma_full_name), "313 pts"),
            Result(3, "3", getString(R.string.Pavel_full_name), "311 pts"),
            Result(4, "4", getString(R.string.Evgeniy_full_name), "258 pts"),
            Result(5, "5", getString(R.string.Lexa_full_name), "205 pts"),
            Result(6, "6", getString(R.string.Denis_full_name), "151 pts"),
            Result(7, "7", getString(R.string.Vova_full_name), "151 pts"),
            Result(8, "8", getString(R.string.Uxnevich_full_name), "124 pts"),
            Result(9, "9", getString(R.string.Leitis_full_name), "88 pts"),
            Result(10, "10", getString(R.string.Vitaliy_full_name), "72 pts"),
            Result(11, "11", getString(R.string.Vodeiko_full_name), "72 pts"),
            Result(12, "12", getString(R.string.Kuprianchik_full_name), "49 pts"),
            Result(13, "13", getString(R.string.Chevichelov_full_name), "36 pts")
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
