package com.ming.sjll.my.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.loginreg.view.RegisteredView;

public class ResetPasswordPresenter extends MvpPresenter<RegisteredView> {
    @Override
    public void attachView(RegisteredView view) {
        super.attachView(view);
        saveCode();
    }

    public void saveCode() {
        getNetData(RetrofitManager.get().create(ApiService.class).saveCode(getToken()),
                new ApiObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        getView().returnCode(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

    public void sendcode(String password, String repassword, String code) {
        getNetData(RetrofitManager.get().create(ApiService.class).savePwd(getToken(), password, repassword, code),
                new ApiObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean bean) {
                        getView().successful(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

}
