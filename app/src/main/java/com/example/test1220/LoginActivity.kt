package com.example.test1220

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: AppCompatActivity(){

    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        //MainActivityを開くソースloginButton
        loginButton.setOnClickListener{
            onLogin()
        }

        //MainActivityを開くソースsnsButton
        snsButton.setOnClickListener{
            onLogin()
        }
    }

    private fun onLogin(){
        val prefs = getSharedPreferences( "prefs", Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean("is_login", true)
        editor.apply() //セーブ
        startActivity(Intent(this, TopActivity::class.java))
        finish()
    }

}