package com.ming.sjll.message.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.ming.sjll.BR;

public class MessageNotifyViewModel extends BaseObservable {
    private String count;
    private String content;
    private int url;
    private int projectApply;//项目统筹未读条数
    private int projectInvite;//项目参与确认未读条数
    private int companyApply;//公司申请未读条数

    @Bindable
    public int getProjectApply() {
        return projectApply;
    }

    public void setProjectApply(int projectApply) {
        this.projectApply = projectApply;
        notifyPropertyChanged(BR.projectApply);
    }

    @Bindable
    public int getProjectInvite() {
        return projectInvite;
    }

    public void setProjectInvite(int projectInvite) {
        this.projectInvite = projectInvite;
        notifyPropertyChanged(BR.projectInvite);
    }

    @Bindable
    public int getCompanyApply() {
        return companyApply;
    }

    public void setCompanyApply(int companyApply) {
        this.companyApply = companyApply;
        notifyPropertyChanged(BR.companyApply);
    }

    @Bindable
    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
        notifyPropertyChanged(com.ming.sjll.BR.count);
    }

    @Bindable
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        notifyPropertyChanged(BR.content);
    }

    @Bindable
    public int getUrl() {
        return url;
    }

    public void setUrl(int url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }
}
