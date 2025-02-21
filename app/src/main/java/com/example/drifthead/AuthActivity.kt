package com.example.drifthead

import android.content.Context
import com.example.drifthead.R
import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import java.util.Locale

class AuthActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var switchTheme: Switch

    private lateinit var buttonRu: Button
    private lateinit var buttonEn: Button
    private lateinit var buttonAuth: Button

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)


        buttonRu = findViewById(R.id.buttonRu)
        buttonEn = findViewById(R.id.buttonEn)
        buttonAuth = findViewById(R.id.buttonAuth)

        switchTheme = findViewById(R.id.switchTheme)

        switchTheme.setOnCheckedChangeListener(this)


        val userLogin: EditText = findViewById(R.id.userLoginAuth)
        val userPassword: EditText = findViewById(R.id.userPasswordAuth)
        val button: Button = findViewById(R.id.buttonAuth )
        val linkToReg: TextView = findViewById(R.id.linkToReg)

        linkToReg.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login =userLogin.text.toString().trim()
            val password =userPassword.text.toString().trim()

            if(login == ""  || password == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else
            {


                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, password)

                if(isAuth)
                {
                    Toast.makeText(this, "Пользователь $login авторизован", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPassword.text.clear()
                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                }
                else
                    Toast.makeText(this, "Пользователь $login НЕ авторизован", Toast.LENGTH_LONG).show()
            }
        }

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
        buttonRu.setTextColor(ContextCompat.getColor(this, textColor))
        buttonEn.setTextColor(ContextCompat.getColor(this, textColor))
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
        buttonRu.setTextColor(ContextCompat.getColor(this, textColor))
        buttonEn.setTextColor(ContextCompat.getColor(this, textColor))
        buttonAuth.setTextColor(ContextCompat.getColor(this, textColor))
        buttonRu.setBackgroundColor(ContextCompat.getColor(this, if (isChecked) R.color.button_dark_background else R.color.button_light_background))
        buttonEn.setBackgroundColor(ContextCompat.getColor(this, if (isChecked) R.color.button_dark_background else R.color.button_light_background))
        buttonAuth.setBackgroundColor(ContextCompat.getColor(this, if (isChecked) R.color.button_dark_background else R.color.button_light_background))
    }
}