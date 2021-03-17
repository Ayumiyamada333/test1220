package com.example.test1220

import android.content.Context
import android.content.Intent
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity: AppCompatActivity() {

    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_top, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.logoutButton -> {
                logout()
            }
            R.id.cartButton -> {
                startActivity(Intent(this, CartActivity::class.java))
            }
        }
        return true
    }

    private fun logout() {
        val prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean("is_login", false)
        editor.apply()
        startActivity(Intent(this, SplashActivity::class.java))
        finish()
    }
}