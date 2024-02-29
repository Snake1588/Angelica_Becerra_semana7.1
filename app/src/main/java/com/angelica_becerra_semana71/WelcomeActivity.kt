package com.angelica_becerra_semana71

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val username = sharedPreferences.getString("username", "Invitado")
        val welcomeTextView: TextView = findViewById(R.id.welcome_text_view)
        welcomeTextView.text = getString(R.string.welcome_message, username)

        // Iniciar la tarea AsyncTask para cargar los datos
        FetchFeriadosTask(this).execute()
    }
}
