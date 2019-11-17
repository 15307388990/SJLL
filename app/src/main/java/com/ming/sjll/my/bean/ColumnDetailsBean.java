package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class ColumnDetailsBean extends BaseBean {


    /**
     * data : {"columnInfo":{"column_id":13,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","content":"这是个专题/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","user_id":3,"img":["/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg"]},"userInfo":{"id":3,"name":"螺蛳粉01113","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","sex":1,"payment_hour":"200.00","payment_day":"2000.00","is_approve":2,"collect_num":2,"company_name":"简称","approve_company_id":5,"is_collect":1},"course":[{"course_id":1,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4","is_pay":0},{"course_id":2,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4","is_pay":0},{"course_id":3,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4","is_pay":0}],"is_collect":0,"related":[{"cloumn_id":17,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题"},{"cloumn_id":18,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题"},{"cloumn_id":19,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * columnInfo : {"column_id":13,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题","content":"这是个专题/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","user_id":3,"img":["/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg"]}
         * userInfo : {"id":3,"name":"螺蛳粉01113","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","sex":1,"payment_hour":"200.00","payment_day":"2000.00","is_approve":2,"collect_num":2,"company_name":"简称","approve_company_id":5,"is_collect":1}
         * course : [{"course_id":1,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4","is_pay":0},{"course_id":2,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4","is_pay":0},{"course_id":3,"cover_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"测试","price":"100","duration":0,"url":"/video/c932ab2a8193515f593fb8cf7e48ec79.mp4","is_pay":0}]
         * is_collect : 0
         * related : [{"cloumn_id":17,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题"},{"cloumn_id":18,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题"},{"cloumn_id":19,"bg_img":"/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","title":"这是个专题"}]
         */

        private ColumnInfoBean columnInfo;
        private UserInfoBean userInfo;
        private int is_collect;
        private List<CourseBean> course;
        private List<RelatedBean> related;

        public ColumnInfoBean getColumnInfo() {
            return columnInfo;
        }

        public void setColumnInfo(ColumnInfoBean columnInfo) {
            this.columnInfo = columnInfo;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public int getIs_collect() {
            return is_collect;
        }

        public void setIs_collect(int is_collect) {
            this.is_collect = is_collect;
        }

        public List<CourseBean> getCourse() {
            return course;
        }

        public void setCourse(List<CourseBean> course) {
            this.course = course;
        }

        public List<RelatedBean> getRelated() {
            return related;
        }

        public void setRelated(List<RelatedBean> related) {
            this.related = related;
        }

        public static class ColumnInfoBean {
            /**
             * column_id : 13
             * bg_img : /uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
             * title : 这是个专题
             * content : 这是个专题/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
             * user_id : 3
             * img : ["/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg","/uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg"]
             */

            private int column_id;
            private String bg_img;
            private String title;
            private String content;
            private int user_id;
            private List<String> img;

            public int getColumn_id() {
                return column_id;
            }

            public void setColumn_id(int column_id) {
                this.column_id = column_id;
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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public List<String> getImg() {
                return img;
            }

            public void setImg(List<String> img) {
                this.img = img;
            }
        }

        public static class UserInfoBean {
            /**
             * id : 3
             * name : 螺蛳粉01113
             * default_avatar : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             * cover_img : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             * sex : 1
             * payment_hour : 200.00
             * payment_day : 2000.00
             * is_approve : 2
             * collect_num : 2
             * company_name : 简称
             * approve_company_id : 5
             * is_collect : 1
             */

            private int id;
            private String name;
            private String default_avatar;
            private String cover_img;
            private int sex;
            private String payment_hour;
            private String payment_day;
            private int is_approve;
            private int collect_num;
            private String company_name;
            private int approve_company_id;
            private int is_collect;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDefault_avatar() {
                return default_avatar;
            }

            public void setDefault_avatar(String default_avatar) {
                this.default_avatar = default_avatar;
            }

            public String getCover_img() {
                return cover_img;
            }

            public void setCover_img(String cover_img) {
                this.cover_img = cover_img;
            }

            public int getSex() {
                return sex;
            }

            public void setSex(int sex) {
                this.sex = sex;
            }

            public String getPayment_hour() {
                return payment_hour;
            }

            public void setPayment_hour(String payment_hour) {
                this.payment_hour = payment_hour;
            }

            public String getPayment_day() {
                return payment_day;
            }

            public void setPayment_day(String payment_day) {
                this.payment_day = payment_day;
            }

            public int getIs_approve() {
                return is_approve;
            }

            public void setIs_approve(int is_approve) {
                this.is_approve = is_approve;
            }

            public int getCollect_num() {
                return collect_num;
            }

            public void setCollect_num(int collect_num) {
                this.collect_num = collect_num;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public int getApprove_company_id() {
                return approve_company_id;
            }

            public void setApprove_company_id(int approve_company_id) {
                this.approve_company_id = approve_company_id;
            }

            public int getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(int is_collect) {
                this.is_collect = is_collect;
            }
        }

        public static class CourseBean {
            /**
             * course_id : 1
             * cover_img : /uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
             * title : 测试
             * price : 100
             * duration : 0
             * url : /video/c932ab2a8193515f593fb8cf7e48ec79.mp4
             * is_pay : 0
             */

            private int course_id;
            private String cover_img;
            private String title;
            private String price;
            private String duration;
            private String url;
            private int is_pay;

            public int getCourse_id() {
                return course_id;
            }

            public void setCourse_id(int course_id) {
                this.course_id = course_id;
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

            public String getDuration() {
                return duration;
            }

            public void setDuration(String duration) {
                this.duration = duration;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getIs_pay() {
                return is_pay;
            }

            public void setIs_pay(int is_pay) {
                this.is_pay = is_pay;
            }
        }

        public static class RelatedBean {
            /**
             * cloumn_id : 17
             * bg_img : /uploads/20191009/5981b80cda99524debee063bfde0a50a.jpg
             * title : 这是个专题
             */

            private int cloumn_id;
            private String bg_img;
            private String title;

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
        }
    }
}