package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

/**
 * @author luoming
 *created at 2019-10-24 15:31
 * 文章列表
*/

public class ArticleListBean extends BaseBean {


    /**
     * data : {"total":2,"per_page":20,"current_page":1,"last_page":1,"data":[{"id":4,"title":"测试文章4","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":12,"link":"www.jietest.site/index/article/details/articleId/4"},{"id":6,"title":"测试文章6","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":0,"link":"www.jietest.site/index/article/details/articleId/6"}]}
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
         * total : 2
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"id":4,"title":"测试文章4","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":12,"link":"www.jietest.site/index/article/details/articleId/4"},{"id":6,"title":"测试文章6","cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","created_time":1571225700,"read_num":0,"link":"www.jietest.site/index/article/details/articleId/6"}]
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
             * id : 4
             * title : 测试文章4
             * cover_img : /uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
             * created_time : 1571225700
             * read_num : 12
             * link : www.jietest.site/index/article/details/articleId/4
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


