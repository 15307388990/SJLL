package com.ming.sjll.my.presenter;

import android.os.Bundle;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.ColumnListBean;
import com.ming.sjll.my.view.ColletionProjectlView;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.view.ComprehensiveView;
import com.ming.sjll.supplier.view.SupplierVisualView;

public class ColletionCoursePresenter extends MvpPresenter<SupplierVisualView> {

    @Override
    public void attachView(SupplierVisualView view, Bundle bundle) {
        super.attachView(view, bundle);
        projectList();
    }

    public void projectList() {
        getNetData(RetrofitManager.get().create(ApiService.class).courseList(getToken()),
                new ApiObserver<ColumnListBean>() {
                    @Override
                    public void onSuccess(ColumnListBean bean) {
                        getView().setColumnList(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
