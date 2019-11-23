package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class ColletionGoodsBean extends BaseBean {


    /**
     * data : {"total":1,"per_page":"20","current_page":1,"last_page":1,"data":[{"goods_id":7,"title":"这是个测试商品12314","payment":"900000.00","payment_type":1,"address":"北京北京市东城区循礼门","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"}]}
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
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"goods_id":7,"title":"这是个测试商品12314","payment":"900000.00","payment_type":1,"address":"北京北京市东城区循礼门","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"}]
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
             * goods_id : 7
             * title : 这是个测试商品12314
             * payment : 900000.00
             * payment_type : 1
             * address : 北京北京市东城区循礼门
             * img : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             */

            private int goods_id;
            private String title;
            private String payment;
            private int payment_type;
            private String address;
            private String img;

            public int getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(int goods_id) {
                this.goods_id = goods_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPayment() {
                return payment;
            }

            public void setPayment(String payment) {
                this.payment = payment;
            }

            public int getPayment_type() {
                return payment_type;
            }

            public void setPayment_type(int payment_type) {
                this.payment_type = payment_type;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }
        }
    }
}