package com.angelica_becerra_semana71

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({

            val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)
            val username = sharedPreferences.getString("username", null)

            val mainIntent = if (username != null) {

                Intent(this, WelcomeActivity::class.java)
            } else {

                Intent(this, LoginActivity::class.java)
            }

            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}