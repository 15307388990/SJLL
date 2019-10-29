package com.ming.sjll.purchaser.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.view.PurchaserHomeView;
import com.ming.sjll.supplier.bean.CikunmBean;
import com.ming.sjll.supplier.bean.HomeAdsBean;
import com.ming.sjll.supplier.bean.HomeColumBean;

public class PurchaserHomePresenter extends MvpPresenter<PurchaserHomeView> {

    public void showDate() {
        getNetData(RetrofitManager.get().create(ApiService.class).getHomeColum("1"),
                new ApiObserver<HomeColumBean>() {
                    @Override
                    public void onSuccess(HomeColumBean bean) {
                        getView().ShowDate(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
        getHomeAds();
    }

    public void getHomeAds() {
        getNetData(RetrofitManager.get().create(ApiService.class).getHomeAds(),
                new ApiObserver<HomeAdsBean>() {
                    @Override
                    public void onSuccess(HomeAdsBean bean) {
                        getView().ShowImg(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
        getColunmChild();

    }

    public void getColunmChild() {
        getNetData(RetrofitManager.get().create(ApiService.class).getColunmChild(),
                new ApiObserver<CikunmBean>() {
                    @Override
                    public void onSuccess(CikunmBean bean) {
                        getView().ShowCikunm(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });

    }

}
