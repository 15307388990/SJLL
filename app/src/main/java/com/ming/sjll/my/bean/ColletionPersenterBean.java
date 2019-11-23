package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class ColletionPersenterBean extends BaseBean {


    /**
     * data : {"total":5,"per_page":20,"current_page":1,"last_page":1,"data":[{"uid":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["模特","摄影师","直播达人"],"tags":[]},{"uid":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["模特","摄影师","直播达人"],"tags":[]},{"uid":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["模特","摄影师","直播达人"],"tags":[]},{"uid":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["模特","摄影师","直播达人"],"tags":[]},{"uid":2,"name":"superMan","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["摄影师","直播达人","模特"],"tags":["白富美"]}]}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total : 5
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"uid":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["模特","摄影师","直播达人"],"tags":[]},{"uid":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["模特","摄影师","直播达人"],"tags":[]},{"uid":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["模特","摄影师","直播达人"],"tags":[]},{"uid":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["模特","摄影师","直播达人"],"tags":[]},{"uid":2,"name":"superMan","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","payment_hour":"0.00","payment_day":"0.00","occupation":["摄影师","直播达人","模特"],"tags":["白富美"]}]
         */

        private int total;
        private int per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPer_page() {
            return per_page;
        }

        public void setPer_page(int per_page) {
            this.per_page = per_page;
        }

        public int getCurrent_page() {
            return current_page;
        }

        public void setCurrent_page(int current_page) {
            this.current_page = current_page;
        }

        public int getLast_page() {
            return last_page;
        }

        public void setLast_page(int last_page) {
            this.last_page = last_page;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uid : 4
             * name : star
             * default_avatar : /uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg
             * cover_img : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             * payment_hour : 0.00
             * payment_day : 0.00
             * occupation : ["模特","摄影师","直播达人"]
             * tags : []
             */

            private int uid;
            private String name;
            private String default_avatar;
            private String cover_img;
            private String payment;
            private List<String> occupation;
            private List<String> tags;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

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

            public String getPayment() {
                return payment;
            }

            public void setPayment(String payment) {
                this.payment = payment;
            }

            public List<String> getOccupation() {
                return occupation;
            }

            public void setOccupation(List<String> occupation) {
                this.occupation = occupation;
            }

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }
        }
    }
}