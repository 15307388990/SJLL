package com.ming.sjll.my.presenter;

import android.os.Bundle;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.ColletionGoodsBean;
import com.ming.sjll.my.view.ColletionGoodslView;
import com.ming.sjll.my.view.ColletionProjectlView;
import com.ming.sjll.supplier.bean.ComprehenBean;

public class ColletionProjectPresenter extends MvpPresenter<ColletionProjectlView> {

    @Override
    public void attachView(ColletionProjectlView view, Bundle bundle) {
        super.attachView(view, bundle);
        projectList();
    }

    public void projectList() {
        getNetData(RetrofitManager.get().create(ApiService.class).projectList(getToken()),
                new ApiObserver<ComprehenBean>() {
                    @Override
                    public void onSuccess(ComprehenBean bean) {
                        getView().ShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
