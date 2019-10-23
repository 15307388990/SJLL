package com.ming.sjll.purchaser.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.bean.AreaBean;
import com.ming.sjll.purchaser.view.CityView;

public class CityPresenter extends MvpPresenter<CityView> {
    //默认 0 返回省, 省id 反市
    public void getrovince() {

        getNetData(RetrofitManager.get().create(ApiService.class).getArea("0"),
                new ApiObserver<AreaBean>() {
                    @Override
                    public void onSuccess(AreaBean bean) {
                        getView().setProvince(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

    public void getCity(String area_id) {
        getNetData(RetrofitManager.get().create(ApiService.class).getArea(area_id),
                new ApiObserver<AreaBean>() {
                    @Override
                    public void onSuccess(AreaBean bean) {
                        getView().setCity(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }
    public void getArea(String area_id) {
        getNetData(RetrofitManager.get().create(ApiService.class).getArea(area_id),
                new ApiObserver<AreaBean>() {
                    @Override
                    public void onSuccess(AreaBean bean) {
                        getView().setArea(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

}
