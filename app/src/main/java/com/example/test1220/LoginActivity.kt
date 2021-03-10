package com.example.test1220

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
            startActivity(Intent(this, MainActivity::class.java))
        }

        //MainActivityを開くソースsnsButton
        snsButton.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

}