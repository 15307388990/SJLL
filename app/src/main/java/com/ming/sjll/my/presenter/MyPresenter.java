package com.ming.sjll.my.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.CompanyBean;
import com.ming.sjll.my.view.MyView;

public class MyPresenter extends MvpPresenter<MyView> {
    public void getIsApprove() {

        getNetData(RetrofitManager.get().create(ApiService.class).getIsApprove("2e9f39acab38ffd042c4baf9f8c75cb7f5cecb26"),
                new ApiObserver<CompanyBean>() {
            @Override
            public void onSuccess(CompanyBean data) {
                getView().ShowData(data);
            }

            @Override
            public void onFailure(int code, String msg) {

            }
        });
    }
}
