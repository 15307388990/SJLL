package com.ming.sjll.message.viewmodel;

import com.ming.sjll.base.bean.BaseBean;

public class MessageNotifyBean extends BaseBean {


    /**
     * data : {"projectApply":0,"projectInvite":0,"companyApply":2}
     */

    private DataBean data;
    private String content;
    private String count;
    private int url;

    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public static class DataBean {
        /**
         * projectApply : 0
         * projectInvite : 0
         * companyApply : 2
         */

        private int projectApply;
        private int projectInvite;
        private int companyApply;

        public int getProjectApply() {
            return projectApply;
        }

        public void setProjectApply(int projectApply) {
            this.projectApply = projectApply;
        }

        public int getProjectInvite() {
            return projectInvite;
        }

        public void setProjectInvite(int projectInvite) {
            this.projectInvite = projectInvite;
        }

        public int getCompanyApply() {
            return companyApply;
        }

        public void setCompanyApply(int companyApply) {
            this.companyApply = companyApply;
        }
    }
}
