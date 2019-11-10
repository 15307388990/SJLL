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
public class ShareUserMessageContent extends MessageContent {

    private String content;
    private String userId;
    private String userName;
    private String headImg;
    private String occupation;

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    private ShareUserMessageContent (String content, String userId, String userName, String headImg, String occupation) {
        this.content = content;
        this.userId = userId;
        this.userName = userName;
        this.headImg = headImg;
        this.occupation = occupation;
    }

    public static ShareUserMessageContent obtain(String content,String userId,String userName,String headImg,String occupation) {
        return new ShareUserMessageContent(content,userId,userName,headImg,occupation);
    }



    public ShareUserMessageContent(Parcel in) {
        content = ParcelUtils.readFromParcel(in);//该类为工具类，消息属性
        userId = ParcelUtils.readFromParcel(in);
        userName = ParcelUtils.readFromParcel(in);
        headImg = ParcelUtils.readFromParcel(in);
        occupation = ParcelUtils.readFromParcel(in);
    }

    public static final Creator<ShareUserMessageContent> CREATOR = new Creator<ShareUserMessageContent>() {

        @Override
        public ShareUserMessageContent createFromParcel(Parcel source) {
            return new ShareUserMessageContent(source);
        }

        @Override
        public ShareUserMessageContent[] newArray(int size) {
            return new ShareUserMessageContent[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        ParcelUtils.writeToParcel(dest, content);//该类为工具类，对消息中属性进行序列化
        ParcelUtils.writeToParcel(dest, userId);
        ParcelUtils.writeToParcel(dest, userName);
        ParcelUtils.writeToParcel(dest, headImg);
        ParcelUtils.writeToParcel(dest, occupation);
    }

    public ShareUserMessageContent(byte[] data) {
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
