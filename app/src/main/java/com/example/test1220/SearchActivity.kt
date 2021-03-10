package com.example.test1220

import android.content.Context
import android.hardware.input.InputManager
import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity: AppCompatActivity(){

    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        searchButton.setOnClickListener {
           search()
        }
    }

    private fun search(){
        val keyWord : String = searchEditText.text.toString()
        var result = if (keyWord.isEmpty()) "検索結果はありません" else keyWord
        resultTextView.text = result
        sendEventHelper.sendSearchEvent(keyWord , result)
        closeKeyboard()
    }

    private fun closeKeyboard(){
        val view =currentFocus
        if(view != null) {
            val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}