package com.ming.sjll.my.presenter;

import android.os.Bundle;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.my.view.HomeageDataView;
import com.ming.sjll.my.view.PersonalDataView;

public class HomeagePresenter extends MvpPresenter<HomeageDataView> {
    private String uid;

    @Override
    public void attachView(HomeageDataView view, Bundle bundle) {
        super.attachView(view, bundle);
        uid = bundle.getString("uid");
        getWorksList();
    }

    public void getWorksList() {

        getNetData(RetrofitManager.get().create(ApiService.class).usercenter(getToken(), uid),
                new ApiObserver<HomePageBean>() {
                    @Override
                    public void onSuccess(HomePageBean data) {
                        getView().ShowData(data);
                    }

                    @Override
                    public void onFailure(int code, String msg) {

                    }
                });
    }

    public void workCollect(int workid) {
        getNetData(RetrofitManager.get().create(ApiService.class).workCollect(getToken(), workid + ""),
                new ApiObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        getView().workCollect(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

    public void collectuser() {
        getNetData(RetrofitManager.get().create(ApiService.class).collectuser(getToken(), uid),
                new ApiObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        getView().collectuser(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }


}
