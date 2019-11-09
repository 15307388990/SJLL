package com.ming.sjll.message.utils


import android.app.Activity
import android.app.Application
import com.ming.sjll.message.extend.CustomExtensionModule
import com.ming.sjll.message.message.PDFMessageContent
import com.ming.sjll.message.message.ShareProductMessageContent
import com.ming.sjll.message.message.ShareProductMessageItemProvider
import io.rong.imkit.DefaultExtensionModule
import io.rong.imkit.IExtensionModule
import io.rong.imkit.RongExtensionManager
import io.rong.imkit.RongIM
import io.rong.imlib.RongIMClient


/**
 * 融云工具类
 */
object RongIMUtils {

    fun init(context: Application) {
        RongIM.init(context)
        RongIM.registerMessageType(PDFMessageContent::class.java)

        RongIM.registerMessageType(ShareProductMessageContent::class.java)
        RongIM.registerMessageTemplate(ShareProductMessageItemProvider())
        setMyExtensionModule()

    }

    fun setMyExtensionModule() {
        val moduleList = RongExtensionManager.getInstance().extensionModules
        var defaultModule: IExtensionModule? = null
        if (moduleList != null) {
            for (module in moduleList) {
                if (module is DefaultExtensionModule) {
                    defaultModule = module
                    break
                }
            }
            if (defaultModule != null) {
                RongExtensionManager.getInstance().unregisterExtensionModule(defaultModule)
                RongExtensionManager.getInstance().registerExtensionModule(CustomExtensionModule())
            }
        }
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

    fun sendCooperation() {
        //发送合作信息
    }

    fun sendInviteMember() {
        //发送邀请同事
    }

    fun sendApply() {
        //发送申请信息
    }

    fun sendPdfMessage() {
        //发送pdfMessage
    }
}

