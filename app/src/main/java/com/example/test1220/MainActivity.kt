package com.example.test1220

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import kotlinx.android.synthetic.main.activity_main.* //?

class MainActivity : AppCompatActivity() {
    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

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
        //ユーザー ID を設定する
        FirebaseAnalytics.getInstance(this).setUserId("aaaaa")
        FirebaseAnalytics.getInstance(this).logEvent("eventname") {
            param("param_user_id", "p_aaaaa")
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

    //clickイベント計測
    private fun initialize() {
        initLayout()
    }

    private fun initLayout() {
        initClick()
    }

    //private fun　削除？
    //inAppWebViewButton　削除？
    //sendEventHelper　削除？
    private fun initClick() {
        inAppWebViewButton.setOnClickListener {
            sendEventHelper.sendSignUpEvent("アプリ内で開く")
            FirebaseAnalytics.getInstance(this).logEvent(FirebaseAnalytics.Event.VALUE) {
                Param(FirebaseAnalytics.Param.VALUE,"アプリ内で開く")
            }
        }

    }
}