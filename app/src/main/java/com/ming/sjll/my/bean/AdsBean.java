package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class AdsBean extends BaseBean {


    /**
     * data : {"total":5,"per_page":"10","current_page":1,"last_page":1,"data":[{"id":11,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"","content":"","put_time":1568888663,"create_time":1568888663,"price":"0.00","is_pay":1},{"id":12,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"","content":"","put_time":1568888675,"create_time":1568888675,"price":"0.00","is_pay":1},{"id":13,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"这是标题","content":"这是类容","put_time":1568888824,"create_time":1568888824,"price":"200.00","is_pay":1},{"id":14,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"这是标题","content":"这是类容","put_time":1568889204,"create_time":1568889204,"price":"200.00","is_pay":1},{"id":15,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"这是标题","content":"这是类容","put_time":1571846400,"create_time":1568889547,"price":"200.00","is_pay":1}]}
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
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"id":11,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"","content":"","put_time":1568888663,"create_time":1568888663,"price":"0.00","is_pay":1},{"id":12,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"","content":"","put_time":1568888675,"create_time":1568888675,"price":"0.00","is_pay":1},{"id":13,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"这是标题","content":"这是类容","put_time":1568888824,"create_time":1568888824,"price":"200.00","is_pay":1},{"id":14,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"这是标题","content":"这是类容","put_time":1568889204,"create_time":1568889204,"price":"200.00","is_pay":1},{"id":15,"user_id":3,"background_img":"/uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg","title":"这是标题","content":"这是类容","put_time":1571846400,"create_time":1568889547,"price":"200.00","is_pay":1}]
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
             * id : 11
             * user_id : 3
             * background_img : /uploads/20191009/5aa5485c075bd34a117208c7f23ca228.jpg
             * title :
             * content :
             * put_time : 1568888663
             * create_time : 1568888663
             * price : 0.00
             * is_pay : 1
             */

            private int id;
            private int user_id;
            private String background_img;
            private String title;
            private String content;
            private int put_time;
            private int create_time;
            private String price;
            private int is_pay;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getBackground_img() {
                return background_img;
            }

            public void setBackground_img(String background_img) {
                this.background_img = background_img;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getPut_time() {
                return put_time;
            }

            public void setPut_time(int put_time) {
                this.put_time = put_time;
            }

            public int getCreate_time() {
                return create_time;
            }

            public void setCreate_time(int create_time) {
                this.create_time = create_time;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public int getIs_pay() {
                return is_pay;
            }

            public void setIs_pay(int is_pay) {
                this.is_pay = is_pay;
            }
        }
    }
}