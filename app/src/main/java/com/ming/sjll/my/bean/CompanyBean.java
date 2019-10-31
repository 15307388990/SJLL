package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

public class CompanyBean extends BaseBean {


    /**
     * data : {"name":"螺蛳粉01113","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","sex":1,"payment_hour":"200.00","payment_day":"2000.00","is_approve":2,"collect_num":2,"company_name":""}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * name : 螺蛳粉01113
         * default_avatar : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
         * cover_img : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
         * sex : 1
         * payment_hour : 200.00
         * payment_day : 2000.00
         * is_approve : 2
         * collect_num : 2
         * company_name :
         */

        private String name;
        private String default_avatar;
        private String cover_img;
        private int sex;
        private String payment_hour;
        private String payment_day;
        private int is_approve;
        private int collect_num;
        private String company_name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDefault_avatar() {
            return default_avatar;
        }

        public void setDefault_avatar(String default_avatar) {
            this.default_avatar = default_avatar;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
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

        public int getIs_approve() {
            return is_approve;
        }

        public void setIs_approve(int is_approve) {
            this.is_approve = is_approve;
        }

        public int getCollect_num() {
            return collect_num;
        }

        public void setCollect_num(int collect_num) {
            this.collect_num = collect_num;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }
    }
}