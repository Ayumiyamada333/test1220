package com.example.test1220

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProductListActivity : AppCompatActivity() {

    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productlist)
    }
}