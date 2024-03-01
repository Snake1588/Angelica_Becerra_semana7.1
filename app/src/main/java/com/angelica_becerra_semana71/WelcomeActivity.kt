package com.angelica_becerra_semana71

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        setupWelcomeMessage()

        setupLogoutButton()

        FetchFeriadosTask(this).execute()
    }

    private fun setupWelcomeMessage() {
        val username = sharedPreferences.getString("username", "Invitado")
        val welcomeTextView: TextView = findViewById(R.id.welcome_text_view)
        welcomeTextView.text = getString(R.string.welcome_message, username)
    }

    private fun setupLogoutButton() {
        val logoutButton: Button = findViewById(R.id.logout_button)
        logoutButton.setOnClickListener {
            logout()
        }
    }

    private fun logout() {
        val editor = sharedPreferences.edit()
        editor.remove("username")
        editor.apply()

        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
        finish()
    }
}