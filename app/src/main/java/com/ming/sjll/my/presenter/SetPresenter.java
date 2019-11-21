package com.ming.sjll.my.presenter;

import android.os.Bundle;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.bean.VersionBean;
import com.ming.sjll.my.view.HomeageDataView;
import com.ming.sjll.my.view.SetDataView;

public class SetPresenter extends MvpPresenter<SetDataView> {

    @Override
    public void attachView(SetDataView view, Bundle bundle) {
        super.attachView(view, bundle);
        userLeaveMsg();
    }

    public void userLeaveMsg() {

        getNetData(RetrofitManager.get().create(ApiService.class).userLeaveMsg(),
                new ApiObserver<VersionBean>() {
                    @Override
                    public void onSuccess(VersionBean data) {
                        getView().ShowData(data);
                    }

                    @Override
                    public void onFailure(int code, String msg) {

                    }
                });
    }



}
