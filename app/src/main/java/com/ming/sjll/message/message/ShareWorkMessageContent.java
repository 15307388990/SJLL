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
@MessageTag(value = "KP:shareWorks", flag = MessageTag.ISCOUNTED | MessageTag.ISPERSISTED)
public class ShareWorkMessageContent extends MessageContent {

    private String content;
    private String userId;
    private String userName;
    private String headImg;
    private String work_id;

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

    public String getWork_id() {
        return work_id;
    }

    public void setWork_id(String work_id) {
        this.work_id = work_id;
    }

    private ShareWorkMessageContent (String content, String userId, String userName, String headImg, String work_id) {
        this.content = content;
        this.userId = userId;
        this.userName = userName;
        this.headImg = headImg;
        this.work_id = work_id;
    }

    public static ShareWorkMessageContent obtain(String content,String userId,String userName,String headImg,String work_id) {
        return new ShareWorkMessageContent(content,userId,userName,headImg,work_id);
    }



    public ShareWorkMessageContent(Parcel in) {
        content = ParcelUtils.readFromParcel(in);//该类为工具类，消息属性
        userId = ParcelUtils.readFromParcel(in);
        userName = ParcelUtils.readFromParcel(in);
        headImg = ParcelUtils.readFromParcel(in);
        work_id = ParcelUtils.readFromParcel(in);
    }

    public static final Creator<ShareWorkMessageContent> CREATOR = new Creator<ShareWorkMessageContent>() {

        @Override
        public ShareWorkMessageContent createFromParcel(Parcel source) {
            return new ShareWorkMessageContent(source);
        }

        @Override
        public ShareWorkMessageContent[] newArray(int size) {
            return new ShareWorkMessageContent[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        ParcelUtils.writeToParcel(dest, content);//该类为工具类，对消息中属性进行序列化
        ParcelUtils.writeToParcel(dest, userId);
        ParcelUtils.writeToParcel(dest, userName);
        ParcelUtils.writeToParcel(dest, headImg);
        ParcelUtils.writeToParcel(dest, work_id);
    }

    public ShareWorkMessageContent(byte[] data) {
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
