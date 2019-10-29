package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

/**
 * @author luoming
 *created at 2019-10-24 15:31
 * 热门文章
*/

public class HotArticleBean extends BaseBean {


    /**
     * data : {"title":"热门文章","data":[{"id":1,"title":"测试文章1","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":10,"link":"www.jietest.site/index/article/details/articleId/1"},{"id":2,"title":"测试文章2","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":111,"link":"www.jietest.site/index/article/details/articleId/2"},{"id":3,"title":"测试文章3","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":11,"link":"www.jietest.site/index/article/details/articleId/3"}]}
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
         * title : 热门文章
         * data : [{"id":1,"title":"测试文章1","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":10,"link":"www.jietest.site/index/article/details/articleId/1"},{"id":2,"title":"测试文章2","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":111,"link":"www.jietest.site/index/article/details/articleId/2"},{"id":3,"title":"测试文章3","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":11,"link":"www.jietest.site/index/article/details/articleId/3"}]
         */

        private String title;
        private List<DataBean> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 1
             * title : 测试文章1
             * cover_img : /uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
             * created_time : 1571225700
             * read_num : 10
             * link : www.jietest.site/index/article/details/articleId/1
             */

            private int id;
            private String title;
            private String cover_img;
            private int created_time;
            private int read_num;
            private String link;

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

            public int getCreated_time() {
                return created_time;
            }

            public void setCreated_time(int created_time) {
                this.created_time = created_time;
            }

            public int getRead_num() {
                return read_num;
            }

            public void setRead_num(int read_num) {
                this.read_num = read_num;
            }

            public String getLink() {
                return link;
            }

            public void setLink(String link) {
                this.link = link;
            }
        }
    }
}


