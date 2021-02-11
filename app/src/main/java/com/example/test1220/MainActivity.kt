package com.example.test1220

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inAppWebViewButton.setOnClickListener {
//            val intent = Intent(this, SubActivity::class.java)
//            startActivity(intent)
            sendEventHelper.sendClickEvent("アプリナイデヒラク", "1")
            FirebaseAnalytics.getInstance(this).logEvent("click_event_name") { // 直接FirebaseAnalyticsで送る方法
                param("click_param_name_a", "アプリ内で開く")
                param("click_param_name_b", "Apuri Naide Hiraku")
            }
        }
        inAppWebViewButton.setOnClickListener {
            val uri = Uri.parse(BROWSER_URL)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
        //ユーザー ID を設定する
        FirebaseAnalytics.getInstance(this).setUserId("aaaaa")
        FirebaseAnalytics.getInstance(this).logEvent("eventname") {
            param("param_user_id", "p_aaaaa")
        }
    }

    companion object {
        private const val BROWSER_URL = "https://test-webviewapp01.jimdofree.com/%E3%82%B5%E3%83%BC%E3%83%93%E3%82%B9/"
    }
}