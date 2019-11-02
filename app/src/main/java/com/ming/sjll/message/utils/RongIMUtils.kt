package com.ming.sjll.message.utils


import android.app.Activity
import android.app.Application

import com.ming.sjll.message.message.PDFMessageContent

import io.rong.imkit.RongIM
import io.rong.imlib.RongIMClient

/**
 * 融云工具类
 */
object RongIMUtils {

    fun init(context: Application) {
        RongIM.init(context)
        RongIM.registerMessageType(PDFMessageContent::class.java)
    }

    fun connect(token: String) {
        RongIM.connect(token, object : RongIMClient.ConnectCallback() {
            override fun onTokenIncorrect() {

            }

            override fun onSuccess(s: String) {

            }

            override fun onError(errorCode: RongIMClient.ErrorCode) {

            }
        })
    }


    fun disconnect() {
        RongIM.getInstance().disconnect()
    }

    fun logout() {
        RongIM.getInstance().logout()
    }

    fun privateChat(activity: Activity, targetUserId: String, title: String) {
        RongIM.getInstance().startPrivateChat(activity, targetUserId, title)
    }

    fun groupChat(activity: Activity, targetGroupId: String, title: String) {
        RongIM.getInstance().startGroupChat(activity, targetGroupId, title)
    }
}

