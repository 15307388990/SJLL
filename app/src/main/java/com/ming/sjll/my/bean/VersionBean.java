package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.io.Serializable;

public class VersionBean extends BaseBean implements Serializable {


    /**
     * data : {"versionCode":1,"versionName":"v1.0","downloadUrl":"http://www.coolpaishop.com/kpsd.apk","versionTip":"您有新的版本需要更新,请更新后使用."}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements  Serializable {
        /**
         * versionCode : 1
         * versionName : v1.0
         * downloadUrl : http://www.coolpaishop.com/kpsd.apk
         * versionTip : 您有新的版本需要更新,请更新后使用.
         */

        private int versionCode;
        private String versionName;
        private String downloadUrl;
        private String versionTip;

        public int getVersionCode() {
            return versionCode;
        }

        public void setVersionCode(int versionCode) {
            this.versionCode = versionCode;
        }

        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getVersionTip() {
            return versionTip;
        }

        public void setVersionTip(String versionTip) {
            this.versionTip = versionTip;
        }
    }
}