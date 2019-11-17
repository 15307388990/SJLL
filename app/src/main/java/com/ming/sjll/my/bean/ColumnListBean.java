package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class ColumnListBean extends BaseBean {


    /**
     * data : {"total":8,"per_page":"20","current_page":1,"last_page":1,"data":[{"cloumn_id":24,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1573546505},{"cloumn_id":23,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1573546447},{"cloumn_id":22,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1573546084},{"cloumn_id":21,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1571975450},{"cloumn_id":20,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":1,"created_time":1571226204},{"cloumn_id":18,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":27,"created_time":1571225811},{"cloumn_id":17,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1571225700},{"cloumn_id":13,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":0}]}
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
         * total : 8
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"cloumn_id":24,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1573546505},{"cloumn_id":23,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1573546447},{"cloumn_id":22,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1573546084},{"cloumn_id":21,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1571975450},{"cloumn_id":20,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":1,"created_time":1571226204},{"cloumn_id":18,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":27,"created_time":1571225811},{"cloumn_id":17,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":1571225700},{"cloumn_id":13,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","play_num":0,"created_time":0}]
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
             * cloumn_id : 24
             * bg_img : /uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
             * title : 这是个专题
             * play_num : 0
             * created_time : 1573546505
             */

            private int cloumn_id;
            private String bg_img;
            private String title;
            private int play_num;
            private int created_time;

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getPlay_num() {
                return play_num;
            }

            public void setPlay_num(int play_num) {
                this.play_num = play_num;
            }

            public int getCreated_time() {
                return created_time;
            }

            public void setCreated_time(int created_time) {
                this.created_time = created_time;
            }
        }
    }
}