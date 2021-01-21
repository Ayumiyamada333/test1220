package com.example.test1220

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.webkit.WebView

class SubActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        // webView
        val myWebView: WebView = findViewById(R.id.webview)
        myWebView.settings.javaScriptEnabled = true//JavaScript を有効にする
        myWebView.loadUrl("https://test-webviewapp01.jimdofree.com/")
        // webView END

        // Enables Always-on
        setAmbientEnabled()
    }
}