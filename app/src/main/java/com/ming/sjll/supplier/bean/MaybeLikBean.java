package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class MaybeLikBean extends BaseBean {

    /**
     * data : {"total":1,"per_page":"10","current_page":1,"last_page":1,"data":[{"id":2,"name":"superMan","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","is_sign":0,"collect_num":2,"occupation":["摄影师","直播达人"],"is_focus":1}]}
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
         * total : 1
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"id":2,"name":"superMan","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","is_sign":0,"collect_num":2,"occupation":["摄影师","直播达人"],"is_focus":1}]
         */

        private int total;
        private String per_page;
        private int current_page;
        private int last_page;
        private List<DataBean> data;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public String getPer_page() {
            return per_page;
        }

        public void setPer_page(String per_page) {
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
             * id : 2
             * name : superMan
             * default_avatar : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             * cover_img : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             * is_sign : 0
             * collect_num : 2
             * occupation : ["摄影师","直播达人"]
             * is_focus : 1
             */

            private int id;
            private String name;
            private String default_avatar;
            private String cover_img;
            private int is_sign;
            private int collect_num;
            private int is_focus;
            private List<String> occupation;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public int getIs_sign() {
                return is_sign;
            }

            public void setIs_sign(int is_sign) {
                this.is_sign = is_sign;
            }

            public int getCollect_num() {
                return collect_num;
            }

            public void setCollect_num(int collect_num) {
                this.collect_num = collect_num;
            }

            public int getIs_focus() {
                return is_focus;
            }

            public void setIs_focus(int is_focus) {
                this.is_focus = is_focus;
            }

            public List<String> getOccupation() {
                return occupation;
            }

            public void setOccupation(List<String> occupation) {
                this.occupation = occupation;
            }
        }
    }
}
