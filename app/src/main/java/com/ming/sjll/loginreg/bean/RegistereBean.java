package com.ming.sjll.loginreg.bean;

import com.ming.sjll.base.bean.BaseBean;

public class RegistereBean extends BaseBean {

    private DataBean bean;

    public DataBean getBean() {
        return bean;
    }

    public void setBean(DataBean bean) {
        this.bean = bean;
    }

    public static class DataBean {

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        private String phone;
    }
}
