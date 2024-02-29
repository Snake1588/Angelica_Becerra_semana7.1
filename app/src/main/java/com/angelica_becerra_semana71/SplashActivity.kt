package com.angelica_becerra_semana71

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration

class SplashActivity : AppCompatActivity() {
    private val SPLASH_DISPLAY_LENGTH: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this))
        val imageView: ImageView = findViewById(R.id.imageView)
        val imageUrl = "https://imgur.com/6WE9jvd"
        ImageLoader.getInstance().displayImage(imageUrl, imageView)

        Handler(Looper.getMainLooper()).postDelayed({

            val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finish()
        }, SPLASH_DISPLAY_LENGTH)
    }
}