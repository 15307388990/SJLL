package com.ming.sjll.message.viewmodel;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class CompanyApplyBean extends BaseBean {


    /**
     * data : {"total":2,"per_page":10,"current_page":1,"last_page":1,"data":[{"apply_id":9,"uid":4,"status":1,"default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","name":"star","personalized":"","occupation":["模特","摄影师","直播达人"]},{"apply_id":7,"uid":2,"status":2,"default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","name":"superMan","personalized":"","occupation":["摄影师","直播达人","模特"]}]}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX  {
        /**
         * total : 2
         * per_page : 10
         * current_page : 1
         * last_page : 1
         * data : [{"apply_id":9,"uid":4,"status":1,"default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","name":"star","personalized":"","occupation":["模特","摄影师","直播达人"]},{"apply_id":7,"uid":2,"status":2,"default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","name":"superMan","personalized":"","occupation":["摄影师","直播达人","模特"]}]
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
             * apply_id : 9
             * uid : 4
             * status : 1
             * default_avatar : /uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg
             * name : star
             * personalized :
             * occupation : ["模特","摄影师","直播达人"]
             */

            private int apply_id;
            private int uid;
            private String status;
            private String default_avatar;
            private String name;
            private String personalized;
            private List<String> occupation;

            public int getApply_id() {
                return apply_id;
            }

            public void setApply_id(int apply_id) {
                this.apply_id = apply_id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getDefault_avatar() {
                return default_avatar;
            }

            public void setDefault_avatar(String default_avatar) {
                this.default_avatar = default_avatar;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPersonalized() {
                return personalized;
            }

            public void setPersonalized(String personalized) {
                this.personalized = personalized;
            }

            public List<String> getOccupation() {
                return occupation;
            }

            public void setOccupation(List<String> occupation) {
                this.occupation = occupation;
            }
        }
    }
}
