package com.ming.sjll.purchaser.bean;

import com.ming.sjll.base.bean.BaseBean;

import java.util.List;

public class AreaBean extends BaseBean {


    /**
     * code : 0
     * data : [{"id":110000,"area_name":"北京","area_code":"Beijing","area_parent_id":0},{"id":120000,"area_name":"天津","area_code":"Tianjin","area_parent_id":0},{"id":130000,"area_name":"河北省","area_code":"Hebei","area_parent_id":0},{"id":140000,"area_name":"山西省","area_code":"Shanxi","area_parent_id":0},{"id":150000,"area_name":"内蒙古自治区","area_code":"Inner Mongolia","area_parent_id":0},{"id":210000,"area_name":"辽宁省","area_code":"Liaoning","area_parent_id":0},{"id":220000,"area_name":"吉林省","area_code":"Jilin","area_parent_id":0},{"id":230000,"area_name":"黑龙江省","area_code":"Heilongjiang","area_parent_id":0},{"id":310000,"area_name":"上海","area_code":"Shanghai","area_parent_id":0},{"id":320000,"area_name":"江苏省","area_code":"Jiangsu","area_parent_id":0},{"id":330000,"area_name":"浙江省","area_code":"Zhejiang","area_parent_id":0},{"id":340000,"area_name":"安徽省","area_code":"Anhui","area_parent_id":0},{"id":350000,"area_name":"福建省","area_code":"Fujian","area_parent_id":0},{"id":360000,"area_name":"江西省","area_code":"Jiangxi","area_parent_id":0},{"id":370000,"area_name":"山东省","area_code":"Shandong","area_parent_id":0},{"id":410000,"area_name":"河南省","area_code":"Henan","area_parent_id":0},{"id":420000,"area_name":"湖北省","area_code":"Hubei","area_parent_id":0},{"id":430000,"area_name":"湖南省","area_code":"Hunan","area_parent_id":0},{"id":440000,"area_name":"广东省","area_code":"Guangdong","area_parent_id":0},{"id":450000,"area_name":"广西壮族自治区","area_code":"Guangxi","area_parent_id":0},{"id":460000,"area_name":"海南省","area_code":"Hainan","area_parent_id":0},{"id":500000,"area_name":"重庆","area_code":"Chongqing","area_parent_id":0},{"id":510000,"area_name":"四川省","area_code":"Sichuan","area_parent_id":0},{"id":520000,"area_name":"贵州省","area_code":"Guizhou","area_parent_id":0},{"id":530000,"area_name":"云南省","area_code":"Yunnan","area_parent_id":0},{"id":540000,"area_name":"西藏自治区","area_code":"Tibet","area_parent_id":0},{"id":610000,"area_name":"陕西省","area_code":"Shaanxi","area_parent_id":0},{"id":620000,"area_name":"甘肃省","area_code":"Gansu","area_parent_id":0},{"id":630000,"area_name":"青海省","area_code":"Qinghai","area_parent_id":0},{"id":640000,"area_name":"宁夏回族自治区","area_code":"Ningxia","area_parent_id":0},{"id":650000,"area_name":"新疆维吾尔自治区","area_code":"Xinjiang","area_parent_id":0},{"id":710000,"area_name":"台湾","area_code":"Taiwan","area_parent_id":0},{"id":810000,"area_name":"香港特别行政区","area_code":"Hong Kong","area_parent_id":0},{"id":820000,"area_name":"澳门特别行政区","area_code":"Macau","area_parent_id":0},{"id":900000,"area_name":"钓鱼岛","area_code":"DiaoyuDao","area_parent_id":0}]
     */

    private List<DataBean> data;


    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 110000
         * area_name : 北京
         * area_code : Beijing
         * area_parent_id : 0
         */

        private int id;
        private String area_name;
        private String area_code;
        private int area_parent_id;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getArea_name() {
            return area_name;
        }

        public void setArea_name(String area_name) {
            this.area_name = area_name;
        }

        public String getArea_code() {
            return area_code;
        }

        public void setArea_code(String area_code) {
            this.area_code = area_code;
        }

        public int getArea_parent_id() {
            return area_parent_id;
        }

        public void setArea_parent_id(int area_parent_id) {
            this.area_parent_id = area_parent_id;
        }
    }
}