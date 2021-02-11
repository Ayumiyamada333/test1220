package com.example.test1220

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

class SendEventHelper(private val context: Context) {

    fun sendSignUpEvent(method: String) {
        val bundle = Bundle().apply {
            putString(FirebaseAnalytics.Param.METHOD, method)
        }
        sendEvent(FirebaseAnalytics.Event.SIGN_UP, bundle)
    }
//demoからコピーしただけ(メモ)
//    fun sendLoginEvent(method: String) {
//        val bundle = Bundle().apply {
//            putString(FirebaseAnalytics.Param.METHOD, method)
//        }
//        sendEvent(FirebaseAnalytics.Event.LOGIN, bundle)
//    }
//
//    fun sendSelectItem(id: Int, name: String, type: String) {
//        val bundle = Bundle().apply {
//            putString(FirebaseAnalytics.Param.ITEM_ID, "$id")
//            putString(FirebaseAnalytics.Param.ITEM_NAME, name)
//            putString(FirebaseAnalytics.Param.CONTENT_TYPE, type)
//        }
//        sendEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle)
//    }
//
//    fun sendShareEvent(shareApplication: String) {
//        val bundle = Bundle().apply {
//            putString("sharedBy", shareApplication)
//        }
//        val eventName = "share_$shareApplication"
//        sendEvent(eventName)
//    }

    fun sendDefaultEvent(bundle: Bundle) {
        FirebaseAnalytics.getInstance(context).setDefaultEventParameters(bundle)
    }
   //
    private fun sendEvent(eventName: String, bundle: Bundle = Bundle()) {
        FirebaseAnalytics.getInstance(context).logEvent(eventName, bundle) // Firebaseへのイベント送信

    }
}