package com.ming.sjll.message.message;

import android.os.Parcel;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import io.rong.common.ParcelUtils;
import io.rong.imlib.MessageTag;
import io.rong.imlib.model.MessageContent;
import io.rong.push.common.RLog;

/**
 * userId：分享的用户id
 * userName：分享的用户名
 * headImg：分享的用户头像
 * work_id：作品id
 */
@MessageTag(value = "KP:shareUser", flag = MessageTag.ISCOUNTED | MessageTag.ISPERSISTED)
public class ShareProductMessageContent extends MessageContent {

    private String content;
    private String userId;
    private String userName;
    private String headImg;
    private String occupation;
    private String work_id;

    public ShareProductMessageContent(Parcel in) {
        content = ParcelUtils.readFromParcel(in);//该类为工具类，消息属性
        userId = ParcelUtils.readFromParcel(in);
        userName = ParcelUtils.readFromParcel(in);
        headImg = ParcelUtils.readFromParcel(in);
        occupation = ParcelUtils.readFromParcel(in);
        work_id = ParcelUtils.readFromParcel(in);
    }

    public static final Creator<ShareProductMessageContent> CREATOR = new Creator<ShareProductMessageContent>() {

        @Override
        public ShareProductMessageContent createFromParcel(Parcel source) {
            return new ShareProductMessageContent(source);
        }

        @Override
        public ShareProductMessageContent[] newArray(int size) {
            return new ShareProductMessageContent[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        ParcelUtils.writeToParcel(dest, content);//该类为工具类，对消息中属性进行序列化
        ParcelUtils.writeToParcel(dest, userId);
        ParcelUtils.writeToParcel(dest, userName);
        ParcelUtils.writeToParcel(dest, headImg);
        ParcelUtils.writeToParcel(dest, occupation);
        ParcelUtils.writeToParcel(dest, work_id);
    }

    public ShareProductMessageContent(byte[] data) {
        String jsonStr = null;
        try {
            jsonStr = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e1) {
        }

        try {
            JSONObject jsonObj = new JSONObject(jsonStr);
            if (jsonObj.has("content")) {
                content = jsonObj.optString("content");
            }
            if (jsonObj.has("userId")) {
                userId = jsonObj.optString("userId");
            }
            if (jsonObj.has("userName")) {
                userName = jsonObj.optString("userName");
            }
            if (jsonObj.has("headImg")) {
                headImg = jsonObj.optString("headImg");
            }
            if (jsonObj.has("occupation")) {
                occupation = jsonObj.optString("occupation");
            }
            if (jsonObj.has("work_id")) {
                work_id = jsonObj.optString("work_id");
            }

        } catch (JSONException e) {
            RLog.e("JSONException", e.getMessage());
        }

    }

    @Override
    public byte[] encode() {
        JSONObject jsonObj = new JSONObject();

        try {
            jsonObj.put("content", getContent());
            if (userId != null) {
                jsonObj.put("userId", userId);
            }
            if (userName != null) {
                jsonObj.put("userName", userName);
            }
            if (headImg != null) {
                jsonObj.put("headImg", headImg);
            }
            if (occupation != null) {

                jsonObj.put("occupation", occupation);
            }
            if (work_id != null) {
                jsonObj.put("work_id", work_id);
            }
        } catch (JSONException e) {
            Log.e("JSONException", e.getMessage());
        }

        try {
            return jsonObj.toString().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return content;
    }
}
