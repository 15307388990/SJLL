package com.ming.sjll.purchaser.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class ProjectManagementBean extends BaseBean {


    /**
     * data : {"total":5,"per_page":20,"current_page":1,"last_page":1,"data":[{"dateTime":1569859200,"list":[{"id":22,"background_image":"/uploads/20191009/84ed27b28e17c419a9ab9ebc68dabace.jpg","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1569859200,"tags":["轻奢风","模特"]},{"id":19,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1569859200,"tags":[]}]},{"dateTime":1567267200,"list":[{"id":16,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"3000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1567267200,"tags":["轻奢风","模特"]},{"id":18,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1567267200,"tags":["轻奢风","模特"]},{"id":17,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1567267200,"tags":["轻奢风","模特"]}]}]}
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
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"dateTime":1569859200,"list":[{"id":22,"background_image":"/uploads/20191009/84ed27b28e17c419a9ab9ebc68dabace.jpg","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1569859200,"tags":["轻奢风","模特"]},{"id":19,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1569859200,"tags":[]}]},{"dateTime":1567267200,"list":[{"id":16,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"3000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1567267200,"tags":["轻奢风","模特"]},{"id":18,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1567267200,"tags":["轻奢风","模特"]},{"id":17,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1567267200,"tags":["轻奢风","模特"]}]}]
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
             * dateTime : 1569859200
             * list : [{"id":22,"background_image":"/uploads/20191009/84ed27b28e17c419a9ab9ebc68dabace.jpg","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1569859200,"tags":["轻奢风","模特"]},{"id":19,"background_image":"/uploads/20190907/035e7b15f49362107b217005622ff293.png","demand":"需求","brand":"品牌","budget":"30000.00","city_id":900000,"area_name":"钓鱼岛","closing_time":1571231236,"created_time":1569859200,"tags":[]}]
             */

            private int dateTime;
            private List<ListBean> list;

            public int getDateTime() {
                return dateTime;
            }

            public void setDateTime(int dateTime) {
                this.dateTime = dateTime;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * id : 22
                 * background_image : /uploads/20191009/84ed27b28e17c419a9ab9ebc68dabace.jpg
                 * demand : 需求
                 * brand : 品牌
                 * budget : 30000.00
                 * city_id : 900000
                 * area_name : 钓鱼岛
                 * closing_time : 1571231236
                 * created_time : 1569859200
                 * tags : ["轻奢风","模特"]
                 */

                private int id;
                private String background_image;
                private String demand;
                private String brand;
                private String budget;
                private int city_id;
                private String area_name;
                private int closing_time;
                private int created_time;
                private List<String> tags;

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

                public int getCity_id() {
                    return city_id;
                }

                public void setCity_id(int city_id) {
                    this.city_id = city_id;
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

                public int getCreated_time() {
                    return created_time;
                }

                public void setCreated_time(int created_time) {
                    this.created_time = created_time;
                }

                public List<String> getTags() {
                    return tags;
                }

                public void setTags(List<String> tags) {
                    this.tags = tags;
                }
            }
        }
    }
}