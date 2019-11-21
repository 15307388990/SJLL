package com.ming.sjll.supplier.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.purchaser.view.PurchaserHomeView;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.bean.MaybeLikBean;
import com.ming.sjll.supplier.bean.TalentPushBean;
import com.ming.sjll.supplier.view.TalentView;

public class TalentPresenter extends MvpPresenter<TalentView> {
    public void talentPush(String type) {
        getNetData(RetrofitManager.get().create(ApiService.class).talentPush(getToken()),
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
        maybeLikBean(type);
    }

    public void maybeLikBean(String type) {
        getNetData(RetrofitManager.get().create(ApiService.class).maybeLike(getToken(), type),
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

    public void addFocus(String focus_user_id) {
        getNetData(RetrofitManager.get().create(ApiService.class).addFocus(getToken(), focus_user_id),
                new ApiObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        getView().showLoading(bean.getMsg());
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });

    }
}
