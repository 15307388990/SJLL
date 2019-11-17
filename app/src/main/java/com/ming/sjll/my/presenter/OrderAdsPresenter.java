package com.ming.sjll.my.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.AdsBean;
import com.ming.sjll.my.bean.CurriculumBean;
import com.ming.sjll.my.view.AdsView;
import com.ming.sjll.my.view.CurriculumView;

public class OrderAdsPresenter extends MvpPresenter<AdsView> {

    @Override
    public void attachView(AdsView view) {
        super.attachView(view);
        getAds("0");
    }

    public void getAds(String status) {
        getNetData(RetrofitManager.get().create(ApiService.class).getAds(getToken(), status),
                new ApiObserver<AdsBean>() {
                    @Override
                    public void onSuccess(AdsBean bean) {
                        getView().ShowData(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
}
