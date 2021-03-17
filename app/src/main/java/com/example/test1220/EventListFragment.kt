package com.example.test1220

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_event_list.*

class EventListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_event_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ここからボタンの処理とかを書く

        //他アプリを開く
        inAppWebViewButton.setOnClickListener {
            val newIntent = Intent()
            newIntent.setClassName(
                "com.example.addapplication",
                "com.example.addapplication.MainActivity"
            )
            activity?.startActivity(newIntent)
        }

    }
}