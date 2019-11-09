package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.io.Serializable;
import java.util.List;

public class PersonalDateBean extends BaseBean implements Serializable {

    /**
     * data : {"total":3,"per_page":20,"current_page":1,"last_page":1,"data":[{"id":5,"user_id":3,"created_time":1567740624,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"],"tagsList":["简约风","复古风"],"collect_num":1,"is_collect":1},{"id":3,"user_id":3,"created_time":1567740619,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"],"tagsList":[],"collect_num":0,"is_collect":0},{"id":2,"user_id":3,"created_time":1567679805,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"],"tagsList":[],"collect_num":1,"is_collect":1}]}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX implements Serializable {
        /**
         * total : 3
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"id":5,"user_id":3,"created_time":1567740624,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"],"tagsList":["简约风","复古风"],"collect_num":1,"is_collect":1},{"id":3,"user_id":3,"created_time":1567740619,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"],"tagsList":[],"collect_num":0,"is_collect":0},{"id":2,"user_id":3,"created_time":1567679805,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"],"tagsList":[],"collect_num":1,"is_collect":1}]
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

        public static class DataBean implements Serializable {
            /**
             * id : 5
             * user_id : 3
             * created_time : 1567740624
             * title : very good
             * describe : 这是个非常好的作品
             * is_del : 0
             * imgList : ["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"]
             * tagsList : ["简约风","复古风"]
             * collect_num : 1
             * is_collect : 1
             */

            private int id;
            private int user_id;
            private int created_time;
            private String title;
            private String describe;
            private int is_del;
            private int collect_num;
            private int is_collect;
            private List<String> imgList;
            private List<String> tagsList;

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

            public int getCreated_time() {
                return created_time;
            }

            public void setCreated_time(int created_time) {
                this.created_time = created_time;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getIs_del() {
                return is_del;
            }

            public void setIs_del(int is_del) {
                this.is_del = is_del;
            }

            public int getCollect_num() {
                return collect_num;
            }

            public void setCollect_num(int collect_num) {
                this.collect_num = collect_num;
            }

            public int getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(int is_collect) {
                this.is_collect = is_collect;
            }

            public List<String> getImgList() {
                return imgList;
            }

            public void setImgList(List<String> imgList) {
                this.imgList = imgList;
            }

            public List<String> getTagsList() {
                return tagsList;
            }

            public void setTagsList(List<String> tagsList) {
                this.tagsList = tagsList;
            }
        }
    }
}