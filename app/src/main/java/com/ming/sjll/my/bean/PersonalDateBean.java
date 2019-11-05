package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.io.Serializable;
import java.util.List;

public class PersonalDateBean extends BaseBean implements Serializable {

    /**
     * data : {"total":7,"per_page":20,"current_page":1,"last_page":1,"data":[{"id":7,"user_id":3,"created_time":1567842025,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":["简约风","复古风"]},{"id":6,"user_id":3,"created_time":1567827636,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":["简约风","复古风"]},{"id":5,"user_id":3,"created_time":1567740624,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]},{"id":4,"user_id":3,"created_time":1567740622,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]},{"id":3,"user_id":3,"created_time":1567740619,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]},{"id":2,"user_id":3,"created_time":1567679805,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]},{"id":1,"user_id":3,"created_time":1567679693,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]}]}
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
         * total : 7
         * per_page : 20
         * current_page : 1
         * last_page : 1
         * data : [{"id":7,"user_id":3,"created_time":1567842025,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":["简约风","复古风"]},{"id":6,"user_id":3,"created_time":1567827636,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":["简约风","复古风"]},{"id":5,"user_id":3,"created_time":1567740624,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]},{"id":4,"user_id":3,"created_time":1567740622,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]},{"id":3,"user_id":3,"created_time":1567740619,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]},{"id":2,"user_id":3,"created_time":1567679805,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]},{"id":1,"user_id":3,"created_time":1567679693,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":[{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}],"tagsList":[]}]
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

        public static class DataBean implements Serializable  {
            /**
             * id : 7
             * user_id : 3
             * created_time : 1567842025
             * title : very good
             * describe : 这是个非常好的作品
             * is_del : 0
             * imgList : [{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"},{"img":"/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"}]
             * tagsList : ["简约风","复古风"]
             */

            private int id;
            private int user_id;
            private int created_time;
            private String title;
            private String describe;
            private int is_del;
            private List<ImgListBean> imgList;
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

            public List<ImgListBean> getImgList() {
                return imgList;
            }

            public void setImgList(List<ImgListBean> imgList) {
                this.imgList = imgList;
            }

            public List<String> getTagsList() {
                return tagsList;
            }

            public void setTagsList(List<String> tagsList) {
                this.tagsList = tagsList;
            }

            public static class ImgListBean {
                /**
                 * img : /uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg
                 */

                private String img;

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }
            }
        }
    }
}