package com.example.test1220

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_top.*

class TopActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top)

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