package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

/**
 * @author luoming
 *created at 2019-10-21 13:44
 * 综合
*/

public class ComprehenBean extends BaseBean {


    /**
     * data : {"total":4,"per_page":20,"current_page":1,"last_page":1,"data":[{"id":19,"background_image":"img_url","demand":"需求","brand":"品牌","budget":"30000.00","area_name":"钓鱼岛","closing_time":1571231236,"tags":"轻奢风"},{"id":18,"background_image":"uploads\\20190907\\035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","area_name":"钓鱼岛","closing_time":1571231236,"tags":"轻奢风"},{"id":17,"background_image":"uploads\\20190907\\035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","area_name":"钓鱼岛","closing_time":1571231236,"tags":"轻奢风"},{"id":16,"background_image":"uploads\\20190907\\035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"3000.00","area_name":"钓鱼岛","closing_time":1571231236,"tags":"轻奢风"}]}
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
         * total : 4
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"id":19,"background_image":"img_url","demand":"需求","brand":"品牌","budget":"30000.00","area_name":"钓鱼岛","closing_time":1571231236,"tags":"轻奢风"},{"id":18,"background_image":"uploads\\20190907\\035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","area_name":"钓鱼岛","closing_time":1571231236,"tags":"轻奢风"},{"id":17,"background_image":"uploads\\20190907\\035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","area_name":"钓鱼岛","closing_time":1571231236,"tags":"轻奢风"},{"id":16,"background_image":"uploads\\20190907\\035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"3000.00","area_name":"钓鱼岛","closing_time":1571231236,"tags":"轻奢风"}]
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
             * id : 19
             * background_image : img_url
             * demand : 需求
             * brand : 品牌
             * budget : 30000.00
             * area_name : 钓鱼岛
             * closing_time : 1571231236
             * tags : 轻奢风
             */

            private int id;
            private String background_image;
            private String demand;
            private String brand;
            private String budget;
            private String area_name;
            private int closing_time;
            private String tags;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getBackground_image() {
                return background_image;
            }

            public void setBackground_image(String background_image) {
                this.background_image = background_image;
            }

            public String getDemand() {
                return demand;
            }

            public void setDemand(String demand) {
                this.demand = demand;
            }

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            public String getBudget() {
                return budget;
            }

            public void setBudget(String budget) {
                this.budget = budget;
            }

            public String getArea_name() {
                return area_name;
            }

            public void setArea_name(String area_name) {
                this.area_name = area_name;
            }

            public int getClosing_time() {
                return closing_time;
            }

            public void setClosing_time(int closing_time) {
                this.closing_time = closing_time;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }
        }
    }
}