package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class CurriculumBean extends BaseBean {


    /**
     * data : {"total":3,"per_page":20,"current_page":1,"last_page":1,"data":[{"columnTitle":"这是个专题","num":"共2节","list":[{"id":1,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4"},{"id":2,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4"}]},{"columnTitle":"这是个专题","num":"共1节","list":[{"id":4,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4"}]}]}
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
         * total : 3
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"columnTitle":"这是个专题","num":"共2节","list":[{"id":1,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4"},{"id":2,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4"}]},{"columnTitle":"这是个专题","num":"共1节","list":[{"id":4,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4"}]}]
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
             * columnTitle : 这是个专题
             * num : 共2节
             * list : [{"id":1,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4"},{"id":2,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4"}]
             */

            private String columnTitle;
            private String num;
            private List<ListBean> list;

            public String getColumnTitle() {
                return columnTitle;
            }

            public void setColumnTitle(String columnTitle) {
                this.columnTitle = columnTitle;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 1
                 * cover_img : /uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
                 * title : 测试
                 * price : 100
                 * duration : 0
                 * url : /video/c932ab2a8193515f593fb8cf7e48ec79.mp4
                 */

                private int id;
                private String cover_img;
                private String title;
                private String price;
                private int duration;
                private String url;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getCover_img() {
                    return cover_img;
                }

                public void setCover_img(String cover_img) {
                    this.cover_img = cover_img;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public int getDuration() {
                    return duration;
                }

                public void setDuration(int duration) {
                    this.duration = duration;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }
    }
}