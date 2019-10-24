package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

/**
 * @author luoming
 *created at 2019-10-24 15:31
 * 首页广告
*/

public class HomeAdsBean extends BaseBean {


    /**
     * data : {"banner_img":"","url":""}
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
         * banner_img :
         * url :
         */

        private String banner_img;
        private String url;

        public String getBanner_img() {
            return banner_img;
        }

        public void setBanner_img(String banner_img) {
            this.banner_img = banner_img;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}


