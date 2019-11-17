package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

/**
 * @author luoming
 * created at 2019-10-24 15:31
 * 置顶文章
 */

public class TopArticleBean extends BaseBean {


    /**
     * data : {"id":5,"title":"测试文章5","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","is_original":1,"link":"www.jietest.site/index/article/details/articleId/5"}
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
         * id : 5
         * title : 测试文章5
         * cover_img : /uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
         * is_original : 1
         * link : www.jietest.site/index/article/details/articleId/5
         */

        private int id;
        private String title;
        private String cover_img;
        private int is_original;
        private String link;
        private int cloumn_id;
        private String bg_img;

        public int getCloumn_id() {
            return cloumn_id;
        }

        public void setCloumn_id(int cloumn_id) {
            this.cloumn_id = cloumn_id;
        }

        public String getBg_img() {
            return bg_img;
        }

        public void setBg_img(String bg_img) {
            this.bg_img = bg_img;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCover_img() {
            return cover_img;
        }

        public void setCover_img(String cover_img) {
            this.cover_img = cover_img;
        }

        public int getIs_original() {
            return is_original;
        }

        public void setIs_original(int is_original) {
            this.is_original = is_original;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}


