package com.ming.sjll.purchaser.presenter;

import android.os.Bundle;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.view.ProjectManagementView;
import com.ming.sjll.purchaser.view.PublishProjectView;
import com.ming.sjll.supplier.bean.HotArticleBean;

public class ProjectManagementPresenter extends MvpPresenter<ProjectManagementView> {
    private String type;

    @Override
    public void attachView(ProjectManagementView view, Bundle bundle) {
        super.attachView(view, bundle);
        type = bundle.getString("type");
        projectManage();
    }

    public void projectManage() {

        getNetData(RetrofitManager.get().create(ApiService.class).projectManage(getToken(), type),
                new ApiObserver<ProjectManagementBean>() {
                    @Override
                    public void onSuccess(ProjectManagementBean bean) {
                        getView().ShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
