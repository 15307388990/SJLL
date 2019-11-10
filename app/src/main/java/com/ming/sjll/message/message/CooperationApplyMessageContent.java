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
 * project_id：需求id
 * demand：需求标题
 * apply_id 申请id
 */
@MessageTag(value = "KP:bCooperation", flag = MessageTag.ISCOUNTED | MessageTag.ISPERSISTED)
public class CooperationApplyMessageContent extends MessageContent {

    private String content;
    private String project_id;
    private String demand;
    private String apply_id;


    private CooperationApplyMessageContent (String content,String project_id,String demand,String apply_id) {
        this.content = content;
        this.project_id = project_id;
        this.demand = demand;
        this.apply_id = apply_id;
    }

    public static CooperationApplyMessageContent obtain(String content,String project_id,String demand,String apply_id) {
        return new CooperationApplyMessageContent(content,project_id,demand,apply_id);
    }



    public CooperationApplyMessageContent(Parcel in) {
        content = ParcelUtils.readFromParcel(in);//该类为工具类，消息属性
        project_id = ParcelUtils.readFromParcel(in);
        demand = ParcelUtils.readFromParcel(in);
        apply_id = ParcelUtils.readFromParcel(in);
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
        ParcelUtils.writeToParcel(dest, project_id);
        ParcelUtils.writeToParcel(dest, demand);
        ParcelUtils.writeToParcel(dest, apply_id);
    }

    public CooperationApplyMessageContent(byte[] data) {
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
            if (jsonObj.has("project_id")) {
                project_id = jsonObj.optString("project_id");
            }
            if (jsonObj.has("demand")) {
                demand = jsonObj.optString("demand");
            }
            if (jsonObj.has("apply_id")) {
                apply_id = jsonObj.optString("apply_id");
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
            if (project_id != null) {
                jsonObj.put("project_id", project_id);
            }
            if (demand != null) {
                jsonObj.put("demand", demand);
            }
            if (apply_id != null) {
                jsonObj.put("apply_id", apply_id);
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
