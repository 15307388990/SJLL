package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class MaybeLikBean extends BaseBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * title : 可能感兴趣的模特
         * list : [{"id":2,"name":"superMan","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","is_sign":0,"is_approve":1,"collect_num":2,"occupation":["摄影师","直播达人","模特"],"is_focus":1},{"id":4,"name":"star","default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","is_sign":0,"is_approve":1,"collect_num":1,"occupation":["模特","摄影师","直播达人"],"is_focus":0}]
         */

        private String title;
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * name : superMan
             * default_avatar : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             * cover_img : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             * is_sign : 0
             * is_approve : 1
             * collect_num : 2
             * occupation : ["摄影师","直播达人","模特"]
             * is_focus : 1
             */

            private int id;
            private String name;
            private String default_avatar;
            private String cover_img;
            private int is_sign;
            private int is_approve;
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
