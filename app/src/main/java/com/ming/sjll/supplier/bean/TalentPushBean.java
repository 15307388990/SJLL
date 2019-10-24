package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

/**
 * @author luoming
 *created at 2019-10-21 13:44
 * 综合
*/

public class TalentPushBean extends BaseBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 2
         * cover_img : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
         * default_avatar : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
         * name : superMan
         * payment_hour : 0.00
         * payment_day : 0.00
         * city_name :
         * tags : ["高富帅"]
         * occupation : ["摄影师","直播达人"]
         */

        private int uid;
        private String cover_img;
        private String default_avatar;
        private String name;
        private String payment_hour;
        private String payment_day;
        private String city_name;
        private List<String> tags;
        private List<String> occupation;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public String getDefault_avatar() {
            return default_avatar;
        }

        public void setDefault_avatar(String default_avatar) {
            this.default_avatar = default_avatar;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPayment_hour() {
            return payment_hour;
        }

        public void setPayment_hour(String payment_hour) {
            this.payment_hour = payment_hour;
        }

        public String getPayment_day() {
            return payment_day;
        }

        public void setPayment_day(String payment_day) {
            this.payment_day = payment_day;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public List<String> getTags() {
            return tags;
        }

        public void setTags(List<String> tags) {
            this.tags = tags;
        }

        public List<String> getOccupation() {
            return occupation;
        }

        public void setOccupation(List<String> occupation) {
            this.occupation = occupation;
        }
    }
}