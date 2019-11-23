package com.ming.sjll.my.presenter;

import android.os.Bundle;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.ColletionPersenterBean;
import com.ming.sjll.my.view.ColletionPersonnelView;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.view.ProjectManagementView;

public class ColletionPersonnelPresenter extends MvpPresenter<ColletionPersonnelView> {

    @Override
    public void attachView(ColletionPersonnelView view, Bundle bundle) {
        super.attachView(view, bundle);
        userList();
    }

    public void userList() {

        getNetData(RetrofitManager.get().create(ApiService.class).userList(getToken()),
                new ApiObserver<ColletionPersenterBean>() {
                    @Override
                    public void onSuccess(ColletionPersenterBean bean) {
                        getView().ShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
