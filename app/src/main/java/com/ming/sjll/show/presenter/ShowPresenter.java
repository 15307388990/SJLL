package com.ming.sjll.show.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.show.bean.ShowWorkBean;
import com.ming.sjll.show.view.ShowView;

public class ShowPresenter extends MvpPresenter<ShowView> {
    public void showDate() {
        getNetData(RetrofitManager.get().create(ApiService.class).getShowWork("2e9f39acab38ffd042c4baf9f8c75cb7f5cecb26"),
                new ApiObserver<ShowWorkBean>() {
                    @Override
                    public void onSuccess(ShowWorkBean bean) {
                        getView().ShowWork(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

    public void workCollect(int workid) {
        getNetData(RetrofitManager.get().create(ApiService.class).workCollect("2e9f39acab38ffd042c4baf9f8c75cb7f5cecb26", workid + ""),
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


}
