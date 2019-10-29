package com.ming.sjll.supplier.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

/**
 * @author luoming
 *created at 2019-10-24 15:31
 * 找人找物
*/

public class CikunmBean extends BaseBean {


    /**
     * data : {"person":[{"id":1,"title":"模特","icon":"/icon/20191021/03d97f00c89f61c8824e5c4ab9b56421.png","identification":""},{"id":2,"title":"摄影师","icon":"/icon/20191021/9807a4e0718783702544daed6c24a068.png","identification":""},{"id":3,"title":"直播达人","icon":"/icon/20191021/e8d61232363a1df8b5887868edcda40c.png","identification":""},{"id":4,"title":"修图师","icon":"/icon/20191021/a33622e83bea660d8ba349e7f22d87bb.png","identification":""},{"id":5,"title":"化妆师","icon":"/icon/20191021/472c9bef4d3a213dba945d6054200a6a.png","identification":""},{"id":6,"title":"搭配师","icon":"/icon/20191021/20be47274efa496fcdb5ba2f19c1ef4b.png","identification":""}],"things":[{"id":7,"title":"摄影场地","icon":"/icon/20191021/d56fbce6b1bb25ce69cd629cbd7b387e.png","identification":""},{"id":8,"title":"服装道具","icon":"/icon/20191021/e57fbbd40da879863070bccf47c0da82.png","identification":""},{"id":9,"title":"器材设备","icon":"/icon/20191021/0132bd0ac2004c4912a59a6f83226911.png","identification":""}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<PersonBean> person;
        private List<ThingsBean> things;

        public List<PersonBean> getPerson() {
            return person;
        }

        public void setPerson(List<PersonBean> person) {
            this.person = person;
        }

        public List<ThingsBean> getThings() {
            return things;
        }

        public void setThings(List<ThingsBean> things) {
            this.things = things;
        }

        public static class PersonBean {
            /**
             * id : 1
             * title : 模特
             * icon : /icon/20191021/03d97f00c89f61c8824e5c4ab9b56421.png
             * identification :
             */

            private int id;
            private String title;
            private String icon;
            private String identification;

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
        }

        public static class ThingsBean {
            /**
             * id : 7
             * title : 摄影场地
             * icon : /icon/20191021/d56fbce6b1bb25ce69cd629cbd7b387e.png
             * identification :
             */

            private int id;
            private String title;
            private String icon;
            private String identification;

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
        }
    }
}


