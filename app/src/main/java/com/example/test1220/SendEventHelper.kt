package com.example.test1220

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class SendEventHelper(private val context: Context) {

    
    fun sendClickEvent(paramC: String, paramD: String) {
        // click_param_name
        val bundle = Bundle()
        bundle.putString("click_param_name_c", paramC)
        bundle.putString("click_param_name_d", paramD)
        sendEvent("click_event_name_by_helper", bundle)
    }

    //Uriのbyをイベント送信
    fun sendUriparamEvent(launchdBy: String?){
        val bundle = Bundle()
        bundle.putString("Uri_param_name", launchdBy)
        sendEvent("uri_event_name", bundle)
    }

    fun sendSignUpEvent(method: String) {
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.METHOD, method)
        }
        sendEvent(FirebaseAnalytics.Event.SIGN_UP, bundle)
    }

    fun sendStartMainActivityEvent(launchBy: String?){ //？Null可能
        val bundle = Bundle().apply {
            putString("launchBy", launchBy)
        }
        sendEvent("StartAppMainActivity", bundle)
    }

    fun sendSearchEvent(keyWord: String, result: String){
        val param = Bundle().apply {
            putString("keyword", keyWord) //パラメータ,変数名アプリにデータ保存
            putString("result", result) //パラメータ,変数名アプリにデータ保存
        }
        sendEvent("search_result", param) //イベント名,パラメータ
    }

    fun sendSearchClickEvent(param1: Int, param2: String, param3: String) {
        val bundle = Bundle().apply {
            putInt("parameter_1", param1)
            putString("parameter_2", param2)
            putString("parameter_3", param3)
        }

        sendEvent("Search_action", bundle)
    }

    //J検証用
    /**
     * 1.1ログイン有無(ログイン前)
     *
     * @param os : Android
     * @param osVersion : 8
     * @param appVersion : 1.0.0
     * @param modelName : Nexus One
     * @param adId : 広告ID
     * @param isOptOut : true -> オプトアウト, false -> オプトイン
     */
    fun sendFirstLoginBeforeEvent(os: String, osVersion: String, appVersion: String, modelName: String, adId: String, isOptOut: Boolean) {
        val bundle = Bundle().apply {
            putString("os_name", os)
            putString("os_version", osVersion)
            putString("app_version", appVersion)
            putString("model_name", modelName)
            putString("ad_id", adId)
            putBoolean("is_opt_out", isOptOut)
        }
        sendEvent("first_login_before", bundle)
    }

    /**
     * 1.1ログイン有無(ログイン後)
     *
     * @param os : Android
     * @param osVersion : 8
     * @param appVersion : 1.0.0
     * @param modelName : Nexus One
     * @param adId : 広告ID
     * @param isOptOut : true -> オプトアウト, false -> オプトイン
     */
    fun sendFirstLoginAfterEvent(os: String, osVersion: String, appVersion: String, modelName: String, adId: String, isOptOut: Boolean) {
        val bundle = Bundle().apply {
            putString("os_name", os)
            putString("os_version", osVersion)
            putString("app_version", appVersion)
            putString("model_name", modelName)
            putString("ad_id", adId)
            putBoolean("is_opt_out", isOptOut)
        }
        sendEvent("first_login_after", bundle)
    }

    /**
     * 他アプリ遷移数
     *
     * @param otherAppPackageName
     */
    fun sendOtherApp(otherAppPackageName: String) {
        val bundle = Bundle().apply {
            putString("package_name", otherAppPackageName)
        }
        sendEvent("other_app", bundle)
    }


    /**
     * FAQ最終ページ到達率
     *
     * @param serviceType
     * @param model
     * @param masterId
     */
    fun sendFaqLastPageEvent(serviceType: Int, model: String, masterId: String) {
        val bundle = Bundle().apply {
            putInt("service_type", serviceType)
            putString("model", model)
            putString("master_id", masterId)
        }
        sendEvent("faq_last_page", bundle)
    }

    /**
     * エラー発生情報(API側)
     * エラー発生情報(アプリ側)
     *
     * @param errorCode
     * @param apiName
     */
    fun sendApiErrorEvent(errorCode: String, apiName: String = "") {
        val bundle = Bundle().apply {
            putString("error_code", errorCode)
            putString("api_name", apiName)
        }
        sendEvent("api_error", bundle)
    }

    /**
     * 電話誘導・起動数
     *
     * @param telephoneNumber
     */
    fun sendTelephoneEvent(telephoneNumber: String) {
        val bundle = Bundle().apply {
            putString("telephone_number", telephoneNumber)
        }
        sendEvent("telephone", bundle)
    }

    /**
     * チャット誘導・起動数
     *
     * @param telephoneNumber
     */
    fun sendChatEvent(telephoneNumber: String) {
        val bundle = Bundle().apply {
            putString("telephone_number", telephoneNumber)
        }
        sendEvent("chat", bundle)
    }

    /**
     * 番組検索ワードの取得
     *
     * @param searchWord
     */
    fun sendSearchChannelEvent(searchWord: String) {
        val bundle = Bundle().apply {
            putString("search_word", searchWord)
        }
        sendEvent("search_channel", bundle)
    }

    /**
     * FAQ解決率
     *
     * @param serviceType
     * @param model
     * @param masterId
     * @param result : 0 -> 未解決, 1 -> 解決
     */
    fun sendFaqActionEvent(serviceType: Int, model: String, masterId: String, result: Int) {
        val bundle = Bundle().apply {
            putInt("service_type", serviceType)
            putString("model", model)
            putString("master_id", masterId)
            putInt("result", result)
        }
        sendEvent("faq_action", bundle)
    }

    /**
     * リモート録画予約：ブラウザ遷移数
     *
     * @param channelName
     * @param broadcastType
     */
    fun sendRemoteRecEvent(channelName: String, broadcastType: String) {
        val bundle = Bundle().apply {
            putString("channel_name", channelName)
            putString("broadcast_type", broadcastType)
        }
        sendEvent("remote_rec", bundle)
    }

    /**
     * 視聴するボタン遷移数
     *
     * @param applicationType
     * @param channelName
     * @param broadcastType
     */
    fun sendViewEvent(applicationType: Int, channelName: String, broadcastType: String) {
        val bundle = Bundle().apply {
            putInt("application_type", applicationType)
            putString("channel_name", channelName)
            putString("broadcast_type", broadcastType)
        }
        sendEvent("view", bundle)
    }

    /**
     * トラブル診断最終ページ到達率
     *
     * @param serviceType
     * @param model
     * @param masterId
     */
    fun sendTroubleLastPageEvent(serviceType: Int, model: String, masterId: String) {
        val bundle = Bundle().apply {
            putInt("service_type", serviceType)
            putString("model", model)
            putString("master_id", masterId)
        }
        sendEvent("trouble_last_page", bundle)
    }

    /**
     * トラブル診断解決率
     *
     * @param serviceType
     * @param model
     * @param masterId
     * @param result
     */
    fun sendTroubleActionEvent(serviceType: Int, model: String, masterId: String, result: Int) {
        val bundle = Bundle().apply {
            putInt("service_type", serviceType)
            putString("model", model)
            putString("master_id", masterId)
            putInt("result", result)
        }
        sendEvent("trouble_action", bundle)
    }

    /**
     * NET診断最終ページ到達率
     *
     * @param serviceType
     * @param model
     * @param managementId
     */
    fun sendNetLastPageEvent(serviceType: Int, model: String, managementId: String) {
        val bundle = Bundle().apply {
            putInt("service_type", serviceType)
            putString("model", model)
            putString("master_id", managementId)
        }
        sendEvent("net_last_page", bundle)
    }

    /**
     * NET診断解決率
     *
     * @param serviceType
     * @param model
     * @param managementId
     * @param result
     */
    fun sendNetActionEvent(serviceType: Int, model: String, managementId: String, result: Int) {
        val bundle = Bundle().apply {
            putInt("service_type", serviceType)
            putString("model", model)
            putString("master_id", managementId)
            putInt("result", result)
        }
        sendEvent("net_action", bundle)
    }

    /**
     * チュートリアル最終ページ到達率
     *
     * @param serviceType
     * @param model
     * @param masterId
     */
    fun sendTutorialLastPageEvent(serviceType: Int, model: String, masterId: String) {
        val bundle = Bundle().apply {
            putInt("service_type", serviceType)
            putString("model", model)
            putString("master_id", masterId)
        }
        sendEvent("tutorial_last_page", bundle)
    }

    /**
     * チュートリアル解決率
     *
     * @param serviceType
     * @param model
     * @param masterId
     * @param result
     */
    fun sendTutorialActionEvent(serviceType: Int, model: String, masterId: String, result: Int) {
        val bundle = Bundle().apply {
            putInt("service_type", serviceType)
            putString("model", model)
            putString("master_id", masterId)
            putInt("result", result)
        }
        sendEvent("tutorial_action", bundle)
    }

    /**
     * 番組リストの放送波切り替え時
     *
     * @param broadcastType
     */
    fun sendBroadcastSwitchEvent(broadcastType: String) {
        val bundle = Bundle().apply {
            putString("broadcast_type", broadcastType)
        }
        sendEvent("Broadcast_Switch", bundle)
    }

    private fun sendEvent(eventName: String, bundle: Bundle = Bundle()) {
        FirebaseAnalytics.getInstance(context).logEvent(eventName, bundle) // Firebaseへのイベント送信
    }
}