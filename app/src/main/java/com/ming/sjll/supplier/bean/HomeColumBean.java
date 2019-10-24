package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;
/**
 * @author luoming
 *created at 2019-10-24 15:31
 * 首页栏目列表
*/

public class HomeColumBean extends BaseBean {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * icon : /icon/20191021/4c9cae610bdfbe40842f05ad91a0531e.png
         * title : 发布项目
         * identification :
         */

        private String icon;
        private String title;
        private String identification;

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIdentification() {
            return identification;
        }

        public void setIdentification(String identification) {
            this.identification = identification;
        }
    }
}


