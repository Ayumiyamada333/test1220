package com.example.test1220

import android.content.Intent
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_top.*

class TopActivity : BaseActivity() {

    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)

        //ユーザー ID を設定する
        FirebaseAnalytics.getInstance(this).setUserId("aaaaa")

        //ユーザープロパティを設定する
        FirebaseAnalytics.getInstance(this).apply {
            setUserProperty("favorite_food", "オレンジ")
            setUserProperty("favorite_drink", "いろはす")
        }

        // ViewPager2の初期化の実行　TopActivityのインスタンス
        val adapter = ViewPagerAdapter(this)
        viewPager2.adapter = adapter //Kotlin

        // TabLayoutの初期化の実行
        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = if (position == 0) "Maine" else "Event一覧"
        }.attach()
    }

    class ViewPagerAdapter(fragmentActivity: FragmentActivity) :FragmentStateAdapter(
        fragmentActivity
    ) {
        override fun getItemCount(): Int = 2
        override fun createFragment(position: Int): Fragment {
            return if (position == 0) {
                MainFragment()
            } else {
                EventListFragment()
            }
        }
    }
}