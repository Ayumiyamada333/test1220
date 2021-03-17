package com.example.test1220

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.recommendButton1
import kotlinx.android.synthetic.main.fragment_main.recommendButton2
import kotlinx.android.synthetic.main.fragment_main.searchButton
import kotlinx.android.synthetic.main.fragment_main.poductButton

class MainFragment : Fragment() {

    private val sendEventHelper by lazy { SendEventHelper(requireContext()) } //SendEventHelper呼び出し

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // ここからボタンの処理とかを書く
        recommendButton1.setOnClickListener {
            moveProductActivity(1)
        }
        recommendButton2.setOnClickListener {
            moveProductActivity(2)
        }

        //SearchActivityを開くソース
        searchButton.setOnClickListener {
            activity?.startActivity(Intent(requireContext(), SearchActivity::class.java))
            sendEventHelper.sendClickEvent("MainFragment", "searchButton")
        }

        //商品一覧を開くソース
        poductButton.setOnClickListener {
            activity?.startActivity(Intent(requireContext(), ProductListActivity::class.java))
        }

    }

    private fun moveProductActivity(productId: Int) {
        var intent = Intent(requireContext(), ProductActivity::class.java)
        intent.putExtra("key_product_id", productId)
        activity?.startActivity(intent)
    }
}