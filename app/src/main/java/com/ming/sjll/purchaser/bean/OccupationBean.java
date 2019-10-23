package com.ming.sjll.purchaser.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;
/**
 * @author luoming
 *created at 2019-10-21 13:44
 * 职业
*/

public class OccupationBean extends BaseBean {


    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * title : 模特
         * icon : /icon/20191011/c5fc457a9ea6ae637a57982c79603d92.png
         * identification :
         */

        private int id;
        private String title;
        private String icon;
        private String identification;
        private boolean selected;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getIdentification() {
            return identification;
        }

        public void setIdentification(String identification) {
            this.identification = identification;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
    }
}