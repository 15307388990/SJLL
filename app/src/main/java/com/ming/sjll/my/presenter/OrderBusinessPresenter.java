package com.ming.sjll.my.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.view.ProjectManagementView;

public class OrderBusinessPresenter extends MvpPresenter<ProjectManagementView> {

    @Override
    public void attachView(ProjectManagementView view) {
        super.attachView(view);
        getBusiness("0");
    }

    public void getBusiness(String status) {

        getNetData(RetrofitManager.get().create(ApiService.class).getBusiness(getToken(), status),
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
