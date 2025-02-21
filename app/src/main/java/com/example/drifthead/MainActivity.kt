package com.example.drifthead

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    private lateinit var switchTheme: Switch
    private lateinit var buttonReg: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchTheme = findViewById(R.id.switchTheme)
        buttonReg = findViewById(R.id.buttonReg)

        switchTheme.setOnCheckedChangeListener(this)

        val userLogin: EditText = findViewById(R.id.userLogin)
        val userEmail: EditText = findViewById(R.id.userEmail)
        val userPassword: EditText = findViewById(R.id.userPassword)
        val button: Button = findViewById(R.id.buttonReg)
        val linkToAuth: TextView = findViewById(R.id.linkToAuth)

        linkToAuth.setOnClickListener {
            var intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPassword.text.toString().trim()

            if (login == "" || email == "" || password == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, password)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPassword.text.clear()
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
        buttonReg.setTextColor(ContextCompat.getColor(this, textColor))
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
        buttonReg.setTextColor(ContextCompat.getColor(this, textColor))
        buttonReg.setBackgroundColor(
            ContextCompat.getColor(
                this,
                if (isChecked) R.color.button_dark_background else R.color.button_light_background
            )
        )

    }
}


