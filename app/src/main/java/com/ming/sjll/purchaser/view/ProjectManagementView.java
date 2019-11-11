package com.ming.sjll.purchaser.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;

public interface ProjectManagementView extends MvpView {
    void ShowData(ProjectManagementBean bean);
}
