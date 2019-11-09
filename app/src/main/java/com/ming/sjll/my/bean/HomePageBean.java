package com.ming.sjll.my.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class HomePageBean extends BaseBean {


    /**
     * data : {"is_approve":2,"userInfo":{"id":3,"name":"螺蛳粉01113","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","sex":1,"payment_hour":"200.00","payment_day":"2000.00","is_approve":2,"collect_num":2,"company_name":"简称","approve_company_id":5,"occupation":["模特"],"tags":[]},"companyInfo":{"company_id":5,"logo":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","short_company_name":"简称","full_company_name":"简单的名称","address":"深圳","signature":"前景非凡哈哈哈哈","describe":"公司空调很冷，，，","is_approve":1,"business":[{"occupation_id":1,"title":"模特"}],"showCase":[{"id":6,"type":1,"title":"这是个测试商品12314","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"},{"id":7,"type":2,"title":"这是个测试商品12314","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"},{"id":3,"type":3,"title":"螺蛳粉01113","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"}]},"work":[{"id":5,"user_id":3,"created_time":1567740624,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"],"tagsList":["简约风","复古风"],"collect_num":1,"is_collect":1}]}
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
         * is_approve : 2
         * userInfo : {"id":3,"name":"螺蛳粉01113","default_avatar":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","cover_img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","sex":1,"payment_hour":"200.00","payment_day":"2000.00","is_approve":2,"collect_num":2,"company_name":"简称","approve_company_id":5,"occupation":["模特"],"tags":[]}
         * companyInfo : {"company_id":5,"logo":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg","short_company_name":"简称","full_company_name":"简单的名称","address":"深圳","signature":"前景非凡哈哈哈哈","describe":"公司空调很冷，，，","is_approve":1,"business":[{"occupation_id":1,"title":"模特"}],"showCase":[{"id":6,"type":1,"title":"这是个测试商品12314","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"},{"id":7,"type":2,"title":"这是个测试商品12314","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"},{"id":3,"type":3,"title":"螺蛳粉01113","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"}]}
         * work : [{"id":5,"user_id":3,"created_time":1567740624,"title":"very good","describe":"这是个非常好的作品","is_del":0,"imgList":["/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg","/uploads/20191010/ff9ac04074337a211ffc7b2a9aa10a03.jpg"],"tagsList":["简约风","复古风"],"collect_num":1,"is_collect":1}]
         */

        private int is_approve;
        private UserInfoBean userInfo;
        private CompanyInfoBean companyInfo;
        private List<WorkBean> work;

        public int getIs_approve() {
            return is_approve;
        }

        public void setIs_approve(int is_approve) {
            this.is_approve = is_approve;
        }

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public CompanyInfoBean getCompanyInfo() {
            return companyInfo;
        }

        public void setCompanyInfo(CompanyInfoBean companyInfo) {
            this.companyInfo = companyInfo;
        }

        public List<WorkBean> getWork() {
            return work;
        }

        public void setWork(List<WorkBean> work) {
            this.work = work;
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
             * occupation : ["模特"]
             * tags : []
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
            private List<String> occupation;
            private List<String> tags;

            public int getIs_collect() {
                return is_collect;
            }

            public void setIs_collect(int is_collect) {
                this.is_collect = is_collect;
            }

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

            public List<String> getOccupation() {
                return occupation;
            }

            public void setOccupation(List<String> occupation) {
                this.occupation = occupation;
            }

            public List<String> getTags() {
                return tags;
            }

            public void setTags(List<String> tags) {
                this.tags = tags;
            }
        }

        public static class CompanyInfoBean {
            /**
             * company_id : 5
             * logo : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
             * short_company_name : 简称
             * full_company_name : 简单的名称
             * address : 深圳
             * signature : 前景非凡哈哈哈哈
             * describe : 公司空调很冷，，，
             * is_approve : 1
             * business : [{"occupation_id":1,"title":"模特"}]
             * showCase : [{"id":6,"type":1,"title":"这是个测试商品12314","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"},{"id":7,"type":2,"title":"这是个测试商品12314","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"},{"id":3,"type":3,"title":"螺蛳粉01113","img":"/uploads/20191009/005157f90de59fb769effb7c7258e546.jpg"}]
             */

            private int company_id;
            private String logo;
            private String short_company_name;
            private String full_company_name;
            private String address;
            private String signature;
            private String describe;
            private int is_approve;
            private List<BusinessBean> business;
            private List<ShowCaseBean> showCase;

            public int getCompany_id() {
                return company_id;
            }

            public void setCompany_id(int company_id) {
                this.company_id = company_id;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public String getShort_company_name() {
                return short_company_name;
            }

            public void setShort_company_name(String short_company_name) {
                this.short_company_name = short_company_name;
            }

            public String getFull_company_name() {
                return full_company_name;
            }

            public void setFull_company_name(String full_company_name) {
                this.full_company_name = full_company_name;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getSignature() {
                return signature;
            }

            public void setSignature(String signature) {
                this.signature = signature;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public int getIs_approve() {
                return is_approve;
            }

            public void setIs_approve(int is_approve) {
                this.is_approve = is_approve;
            }

            public List<BusinessBean> getBusiness() {
                return business;
            }

            public void setBusiness(List<BusinessBean> business) {
                this.business = business;
            }

            public List<ShowCaseBean> getShowCase() {
                return showCase;
            }

            public void setShowCase(List<ShowCaseBean> showCase) {
                this.showCase = showCase;
            }

            public static class BusinessBean {
                /**
                 * occupation_id : 1
                 * title : 模特
                 */

                private int occupation_id;
                private String title;

                public int getOccupation_id() {
                    return occupation_id;
                }

                public void setOccupation_id(int occupation_id) {
                    this.occupation_id = occupation_id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }

            public static class ShowCaseBean {
                /**
                 * id : 6
                 * type : 1
                 * title : 这是个测试商品12314
                 * img : /uploads/20191009/005157f90de59fb769effb7c7258e546.jpg
                 */

                private int id;
                private int type;
                private String title;
                private String img;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }
            }
        }

        public static class WorkBean {
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