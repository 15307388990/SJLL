package com.ming.sjll.loginreg.bean;

import com.ming.sjll.base.bean.BaseBean;

public class LoginBean extends BaseBean {

    private DataBean bean;

    public DataBean getBean() {
        return bean;
    }

    public void setBean(DataBean bean) {
        this.bean = bean;
    }

    public static class DataBean {
        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        private String token;
    }
}
