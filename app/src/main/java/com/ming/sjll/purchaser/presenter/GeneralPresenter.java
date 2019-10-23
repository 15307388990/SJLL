package com.ming.sjll.purchaser.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.purchaser.view.GeneralView;

public class GeneralPresenter extends MvpPresenter<GeneralView> {
    public void getOccupation() {
        getNetData(RetrofitManager.get().create(ApiService.class).getOccupation(),
                new ApiObserver<OccupationBean>() {
                    @Override
                    public void onSuccess(OccupationBean bean) {
                        getView().getOccupation(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

}
