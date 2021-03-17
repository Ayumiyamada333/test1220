package com.example.test1220

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : AppCompatActivity() {

    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        searchButton.setOnClickListener {
            search()

            //検索ボタンのクリックイベント取得(直接)
            searchButton.setOnClickListener {
                FirebaseAnalytics.getInstance(this).logEvent("click_event_name") { // 直接FirebaseAnalyticsでデータを送る方法
                    param("click_param_name_a", "検索") //パラメータ,値
                    param("click_param_name_b", "ケンサク") //パラメータ,値
                }
            }

            //検索ボタンのクリックイベント取得(sendEventHelper)
            sendEventHelper.sendSearchClickEvent(0, "[OSバージョン]","検索結果表示")
        }

    }

    private fun search() {
        val keyWord: String = searchEditText.text.toString()
        var result = if (keyWord.isEmpty()) "検索結果はありません" else keyWord
        resultTextView.text = result
        sendEventHelper.sendSearchEvent(keyWord, result) //sendEventHelperでデータを送る方法 変数名=keyWord,result
        closeKeyboard()
    }

    private fun closeKeyboard() {
        val view = currentFocus
        if (view != null) {
            val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}