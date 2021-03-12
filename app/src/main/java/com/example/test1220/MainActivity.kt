package com.example.test1220

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import kotlinx.android.synthetic.main.activity_main.* //app\build.gradleに追加　id 'kotlin-android-extensions'

//class MainActivity : AppCompatActivity() {
//    private val sendEventHelper by lazy { SendEventHelper(this) } //SendEventHelper呼び出し
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        //Urlスキームからの情報を受け取る
//        val uri= intent.data
//        val launchByApplicationName = intent.data?.getQueryParameter("by")
//        sendEventHelper.sendUriparamEvent(launchByApplicationName)
//        println("uri:$uri")
//        if(uri !=null){
//            val byValue= uri.getQueryParameter("by")
//            println("byValue:$byValue")
//        }
//
//        //文字列key_launch_byがあった場合その値を取得する(インテントの場合
//        // )
//        var launchBy = intent.getStringExtra("key_launch_by") //入っていない場合もある(直接アプリ起動した場合など)
//        if(launchBy != null) //Nullじゃない場合にイベントを取得
//        sendEventHelper.sendStartMainActivityEvent(launchBy) //イベント計測
////        println("launchBy:$launchBy")
//
//        //他アプリを開く
//        openButton.setOnClickListener{
//            sendEventHelper.sendClickEvent("openButton","com.example.addapplication") //イベント計測(クリックイベントを使用)
//            sendEventHelper.sendOtherApp("[パッケージ名]") //J検証用
//            val newIntent = Intent()
//            newIntent.setClassName("com.example.addapplication", "com.example.addapplication.MainActivity")
//            startActivity(newIntent)
//        }
//
//        //ユーザー ID を設定する
//        FirebaseAnalytics.getInstance(this).setUserId("aaaaa")
//        FirebaseAnalytics.getInstance(this).logEvent("eventname") {//パラメータとしてuserIDを取得
//            param("param_user_id", "p_aaaaa") //パラメータとしてuserIDを取得
//        }
//
//        //ユーザープロパティを設定する
//        FirebaseAnalytics.getInstance(this).apply {
//            setUserProperty("favorite_food", "鯖の塩焼き")
//            setUserProperty("favorite_drink", "いろはす")
//        }
//
//        //アプリ内で開く(イベント)
//        inAppWebViewButton.setOnClickListener {
//            sendEventHelper.sendClickEvent("アプリナイデヒラク", "1") //　他ファイルを参照して送る方法
//            FirebaseAnalytics.getInstance(this).logEvent("click_event_name") { // 直接FirebaseAnalyticsで送る方法
//                param("click_param_name_a", "アプリ内で開く")
//                param("click_param_name_b", "Apuri Naide Hiraku")
//            }
//            //アプリ内ブラウザを開くソース
//            val intent = Intent(this, SubActivity::class.java)
//            startActivity(intent)
//        }
//
//        //外部ブラウザで開く(イベント)
//        browserButton.setOnClickListener {
//            sendEventHelper.sendClickEvent("ガイブブラウザデヒラク","2")// 他ファイルを参照して送る方法
//            FirebaseAnalytics.getInstance(this).logEvent("click_event_name") { // 直接FirebaseAnalyticsで送る方法
//                param("click_param_name_a", "外部ブラウザで開く")
//            }
//            //外部ブラウザで開くソース
//            val uri = Uri.parse(BROWSER_URL)
//            val intent = Intent(Intent.ACTION_VIEW, uri)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            intent.putExtra("key_launch_by", "遷移計測_外部ブラウザ") //BROWSER_URLが処理されたタイミングで値を送っている
//            startActivity(intent)
//        }
//
//        //SearchActivityを開くソース
//        searchButton.setOnClickListener{
//            startActivity(Intent(this, SearchActivity::class.java))
//        }
//
//        //J検証用
//        // ログイン前後情報
//        sendEventHelper.sendFirstLoginBeforeEvent("Android", "${Build.VERSION.SDK_INT}", BuildConfig.VERSION_NAME, Build.MODEL, "", false)
//
//        // ログイン固有情報（PPID）の取得
//        FirebaseAnalytics.getInstance(this).apply {
//            setUserProperty("PPID", "[PPID]")
//        }
//
//        // ログイン不随情報の取得
//        FirebaseAnalytics.getInstance(this).apply {
//            setUserProperty("service", "[サービス名]")
//            setUserProperty("area", "[エリア情報]")
//            setUserProperty("corp", "[Corp]")
//            setUserProperty("stb", "[利用機種]")
//        }
//
//        // 他アプリ遷移数
//        sendEventHelper.sendOtherApp("[パッケージ名]")
//
//        // エラー(API側)
//        sendEventHelper.sendApiErrorEvent("[エラーコード]","[API名]")
//        // エラー(アプリ側)
//        sendEventHelper.sendApiErrorEvent("[エラーコード]")
//
//        // 電話誘導・起動数
//        sendEventHelper.sendTelephoneEvent("[電話番号]")
//
//        // チャット誘導・起動数
//        sendEventHelper.sendChatEvent("[電話番号]")
//
//        // 番組検索ワードの取得
//        sendEventHelper.sendSearchChannelEvent("[検索ワード]")
//
//        // FAQ最終ページ到達率
//        sendEventHelper.sendFaqLastPageEvent(0, "[型番]", "[選択マスタID]")
//
//        // FAQ解決率
//        sendEventHelper.sendFaqActionEvent(0, "[型番]", "[選択マスタID]", 0)
//
//        // リモート録画予約：ブラウザ遷移数
//        sendEventHelper.sendRemoteRecEvent("[番組名]", "[放送波]")
//
//        // 視聴するボタン遷移数
//        sendEventHelper.sendViewEvent(0, "[番組名]", "[放送波]")
//
//        // トラブル診断最終ページ到達率
//        sendEventHelper.sendTroubleLastPageEvent(0, "[型番]", "[選択マスタID]")
//
//        // トラブル診断解決率
//        sendEventHelper.sendTroubleActionEvent(0, "[型番]", "[選択マスタID]", 0)
//
//        // NET診断最終ページ到達率
//        sendEventHelper.sendNetLastPageEvent(0, "[型番]", "[管理ID]")
//
//        // NET診断解決率
//        sendEventHelper.sendNetActionEvent(0, "[型番]", "[管理ID]", 0)
//
//        // チュートリアル最終ページ到達率
//        sendEventHelper.sendTutorialLastPageEvent(0, "[型番]", "[選択マスタID]")
//
//        // チュートリアル解決率
//        sendEventHelper.sendTutorialActionEvent(0, "[型番]", "[選択マスタID]", 0)
//
//        // 番組リストの放送波切り替え時
//        sendEventHelper.sendBroadcastSwitchEvent("[放送波]")
//
//
//    }
//    //外部URLを読み込む
//    companion object {
//        private const val BROWSER_URL = "https://test-webviewapp01.jimdofree.com/%E3%82%B5%E3%83%BC%E3%83%93%E3%82%B9/"
//    }
//}