package com.ming.sjll.show.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

/**
 * @author luoming
 *created at 2019-10-24 15:31
 * SHow列表
*/

public class ShowWorkBean extends BaseBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * uid : 3
         * name : 螺蛳粉0111
         * default_avatar : uploads\20190907\035e7b15f49362107b217005622ff293.png
         * work_id : 7
         * cover_img : /uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg
         * is_like : 0
         * occupation : ["模特","摄影师","直播达人"]
         */

        private int uid;
        private String name;
        private String default_avatar;
        private int work_id;
        private String cover_img;
        private int is_like;
        private List<String> occupation;

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

        public int getWork_id() {
            return work_id;
        }

        public void setWork_id(int work_id) {
            this.work_id = work_id;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public int getIs_like() {
            return is_like;
        }

        public void setIs_like(int is_like) {
            this.is_like = is_like;
        }

        public List<String> getOccupation() {
            return occupation;
        }

        public void setOccupation(List<String> occupation) {
            this.occupation = occupation;
        }
    }
}


