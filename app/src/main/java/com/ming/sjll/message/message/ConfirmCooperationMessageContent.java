package com.ming.sjll.message.message;

import android.os.Parcel;
import android.text.TextUtils;
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
 * status 1 接受 2拒绝
 */
@MessageTag(value = "KP:sendCooperation", flag = MessageTag.ISCOUNTED | MessageTag.ISPERSISTED)
public class ConfirmCooperationMessageContent extends MessageContent {

    private String content;
    private String project_id;
    private String demand;
    private String apply_id;
    private String status;

    public static String received() {
        return "1";
    }


    public String statusStr() {
        if (isReceived()){
            return "已接受";
        }
        return "已拒绝";
    }


    public static String refuseed() {
        return "2";
    }

    public boolean isReceived() {
        return TextUtils.equals(getStatus(), "1");
    }


    private ConfirmCooperationMessageContent(String content, String project_id, String demand, String apply_id, String status) {
        this.content = content;
        this.project_id = project_id;
        this.demand = demand;
        this.apply_id = apply_id;
        this.status = status;
    }

    public static ConfirmCooperationMessageContent obtain(String content, String project_id, String demand, String apply_id, String status) {
        return new ConfirmCooperationMessageContent(content, project_id, demand, apply_id, status);
    }


    public ConfirmCooperationMessageContent(Parcel in) {
        content = ParcelUtils.readFromParcel(in);//该类为工具类，消息属性
        project_id = ParcelUtils.readFromParcel(in);
        demand = ParcelUtils.readFromParcel(in);
        apply_id = ParcelUtils.readFromParcel(in);
        status = ParcelUtils.readFromParcel(in);
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
        ParcelUtils.writeToParcel(dest, status);
    }

    public ConfirmCooperationMessageContent(byte[] data) {
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
            if (jsonObj.has("status")) {
                apply_id = jsonObj.optString("status");
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
            if (status != null) {
                jsonObj.put("status", apply_id);
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

    public void setContent(String content) {
        this.content = content;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getDemand() {
        return demand;
    }

    public void setDemand(String demand) {
        this.demand = demand;
    }

    public String getApply_id() {
        return apply_id;
    }

    public void setApply_id(String apply_id) {
        this.apply_id = apply_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return content;
    }
}
