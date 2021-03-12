package com.example.test1220

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
            moveNextActivity()
        }, 1000L)
    }

    private fun moveNextActivity() { // ログインしていたら TopActivityへ　していなければ　LoginActivityへ
        val prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val isLogin = prefs.getBoolean("is_login", false)
        if (isLogin) {
            startActivity(Intent(this, TopActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
        finish()
    }
}