package com.example.test1220

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inAppWebViewButton = findViewById<Button>(R.id.inAppWebViewButton)
        val browserButton = findViewById<Button>(R.id.browserButton)
        inAppWebViewButton.setOnClickListener {
            moveSubActivity()
        }
        browserButton.setOnClickListener {
            showBrowser()
        }
    }

    private fun moveSubActivity() {
        val intent = Intent(this, SubActivity::class.java)
        startActivity(intent)
    }

    private fun showBrowser() {
        val uri = Uri.parse(BROWSER_URL)
        val intent = Intent(Intent.ACTION_VIEW, uri)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    companion object {
        private const val BROWSER_URL = "https://test-webviewapp01.jimdofree.com/%E3%82%B5%E3%83%BC%E3%83%93%E3%82%B9/"
    }
}