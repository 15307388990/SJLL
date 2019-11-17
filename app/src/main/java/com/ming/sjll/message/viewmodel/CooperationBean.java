package com.ming.sjll.message.viewmodel;


import com.ming.sjll.base.bean.BaseBean;

public class CooperationBean extends BaseBean {

    /**
     * data : {"apply_id":"11","apply_type":"aCooperation"}
     */

    private DataBean data;

    public void setData(DataBean data) {
        this.data = data;
    }

    public CooperationBean.DataBean getData() {
        return data;
    }

    public static class DataBean   {
        /**
         * apply_id : 11
         * apply_type : aCooperation
         */

        private String apply_id;
        private String apply_type;

        public String getApply_id() {
            return apply_id;
        }

        public void setApply_id(String apply_id) {
            this.apply_id = apply_id;
        }

        public String getApply_type() {
            return apply_type;
        }

        public void setApply_type(String apply_type) {
            this.apply_type = apply_type;
        }
    }
}
