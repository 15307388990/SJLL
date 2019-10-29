package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

/**
 * @author luoming
 *created at 2019-10-24 15:31
 * 热门作者
*/

public class HotAuthorBean extends BaseBean {


    /**
     * data : {"title":"热门作者","data":[{"uid":3,"default_avatar":"uploads\\20190907\\035e7b15f49362107b217005622ff293.png","name":"螺蛳粉0111","occupation":["模特","摄影师","直播达人"]},{"uid":4,"default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","name":"star","occupation":["模特","摄影师","直播达人"]}]}
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
         * title : 热门作者
         * data : [{"uid":3,"default_avatar":"uploads\\20190907\\035e7b15f49362107b217005622ff293.png","name":"螺蛳粉0111","occupation":["模特","摄影师","直播达人"]},{"uid":4,"default_avatar":"/uploads/20191009/ce29bca2d40a283d605f1fae75914919.jpg","name":"star","occupation":["模特","摄影师","直播达人"]}]
         */

        private String title;
        private List<DataBean> data;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uid : 3
             * default_avatar : uploads\20190907\035e7b15f49362107b217005622ff293.png
             * name : 螺蛳粉0111
             * occupation : ["模特","摄影师","直播达人"]
             */

            private int uid;
            private String default_avatar;
            private String name;
            private List<String> occupation;

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
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

            public List<String> getOccupation() {
                return occupation;
            }

            public void setOccupation(List<String> occupation) {
                this.occupation = occupation;
            }
        }
    }
}


