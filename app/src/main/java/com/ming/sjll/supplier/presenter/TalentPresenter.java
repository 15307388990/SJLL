package com.ming.sjll.supplier.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.view.PurchaserHomeView;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.bean.MaybeLikBean;
import com.ming.sjll.supplier.bean.TalentPushBean;
import com.ming.sjll.supplier.view.TalentView;

public class TalentPresenter extends MvpPresenter<TalentView> {
    public void talentPush() {
        getNetData(RetrofitManager.get().create(ApiService.class).talentPush("2e9f39acab38ffd042c4baf9f8c75cb7f5cecb26"),
                new ApiObserver<TalentPushBean>() {
                    @Override
                    public void onSuccess(TalentPushBean bean) {
                        getView().talentPush(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
        maybeLikBean();
    }

    public void maybeLikBean() {
        getNetData(RetrofitManager.get().create(ApiService.class).maybeLike("2e9f39acab38ffd042c4baf9f8c75cb7f5cecb26"),
                new ApiObserver<MaybeLikBean>() {
                    @Override
                    public void onSuccess(MaybeLikBean bean) {
                        getView().maybeLike(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });

    }
}
