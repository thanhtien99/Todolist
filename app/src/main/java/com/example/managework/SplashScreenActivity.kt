package com.example.managework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.managework.mvvmtodolist.ui.MainActivity

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val ic_splash = findViewById<ImageView>(R.id.ic_splash)
        ic_splash.alpha = 0f
        ic_splash.animate().setDuration(2000).alpha(1f).withEndAction {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }
    }
}