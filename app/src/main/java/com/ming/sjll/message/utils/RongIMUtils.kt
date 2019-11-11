package com.ming.sjll.message.utils


import android.app.Activity
import android.app.Application
import com.ming.sjll.message.extend.CustomExtensionModule
import com.ming.sjll.message.message.*
import io.rong.imkit.DefaultExtensionModule
import io.rong.imkit.IExtensionModule
import io.rong.imkit.RongExtensionManager
import io.rong.imkit.RongIM
import io.rong.imlib.IRongCallback
import io.rong.imlib.RongIMClient
import io.rong.imlib.model.Conversation
import io.rong.imlib.model.Message


/**
 * 融云工具类
 */
object RongIMUtils {

    fun init(context: Application) {

        RongIM.init(context)

        initMessage()

        initExtensionModule()

    }

    private fun initMessage() {
        RongIM.registerMessageType(ConfirmCooperationMessageContent::class.java)
        RongIM.registerMessageType(CooperationApplyMessageContent::class.java)
        RongIM.registerMessageType(CooperationMessageContent::class.java)
        RongIM.registerMessageType(ShareUserMessageContent::class.java)
        RongIM.registerMessageType(ShareWorkMessageContent::class.java)

        RongIM.registerMessageTemplate(ConfirmCooperationMessageItemProvider())
        RongIM.registerMessageTemplate(CooperationApplyMessageItemProvider())
        RongIM.registerMessageTemplate(CooperationMessageItemProvider())
        RongIM.registerMessageTemplate(ShareUserMessageItemProvider())
        RongIM.registerMessageTemplate(ShareWorkMessageItemProvider())
    }

    fun initExtensionModule() {
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

    //发送合作确认
    fun sendConfirmCooperation(type: Conversation.ConversationType, targetId: String, messageContent: ConfirmCooperationMessageContent) {
        var message = Message.obtain(targetId, type, messageContent)
        var pushContent =  "[确认合作]"
         if (!messageContent.isReceived){
             pushContent = "[拒绝合作]"
         }
        var pushData = String(messageContent.encode())
        RongIM.getInstance().sendMessage(message, pushContent, pushData, object : IRongCallback.ISendMessageCallback {

            override fun onAttached(var1: Message) {

            }

            override fun onSuccess(var1: Message) {

            }

            override fun onError(var1: Message, var2: RongIMClient.ErrorCode) {

            }
        })
    }



    fun sendCooperationApply(type: Conversation.ConversationType, targetId: String, messageContent: CooperationApplyMessageContent) {
        //发送申请信息
        var message = Message.obtain(targetId, type, messageContent)
        var pushContent = "[合作]"
        var pushData = String(messageContent.encode())
        RongIM.getInstance().sendMessage(message, pushContent, pushData, object : IRongCallback.ISendMessageCallback {

            override fun onAttached(var1: Message) {

            }

            override fun onSuccess(var1: Message) {

            }

            override fun onError(var1: Message, var2: RongIMClient.ErrorCode) {

            }
        })
    }

    //发送合作信息
    fun sendCooperation(type: Conversation.ConversationType, targetId: String, messageContent: CooperationMessageContent) {
        var message = Message.obtain(targetId, type, messageContent)
        var pushContent =  "[合作]"
        var pushData = String(messageContent.encode())
        RongIM.getInstance().sendMessage(message, pushContent, pushData, object : IRongCallback.ISendMessageCallback {

            override fun onAttached(var1: Message) {

            }

            override fun onSuccess(var1: Message) {

            }

            override fun onError(var1: Message, var2: RongIMClient.ErrorCode) {

            }
        })
    }


    fun sendShareUser(type: Conversation.ConversationType, targetId: String, messageContent: ShareUserMessageContent) {
        //发送邀请同事
        var message = Message.obtain(targetId, type, messageContent)
        var pushContent = "[资料分享]"
        var pushData = String(messageContent.encode())
        RongIM.getInstance().sendMessage(message, pushContent, pushData, object : IRongCallback.ISendMessageCallback {

            override fun onAttached(var1: Message) {

            }

            override fun onSuccess(var1: Message) {

            }

            override fun onError(var1: Message, var2: RongIMClient.ErrorCode) {

            }
        })
    }
    fun sendShareWork(type: Conversation.ConversationType, targetId: String, messageContent: ShareWorkMessageContent) {
        //发送邀请同事
        var message = Message.obtain(targetId, type, messageContent)
        var pushContent = "[作品分享]"
        var pushData = String(messageContent.encode())
        RongIM.getInstance().sendMessage(message, pushContent, pushData, object : IRongCallback.ISendMessageCallback {

            override fun onAttached(var1: Message) {

            }

            override fun onSuccess(var1: Message) {

            }

            override fun onError(var1: Message, var2: RongIMClient.ErrorCode) {

            }
        })
    }

}

