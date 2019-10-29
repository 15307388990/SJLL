package com.ming.sjll.loginreg.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.view.LoginView;
import com.ming.sjll.purchaser.view.PublishProjectView;

public class LoginPresenter extends MvpPresenter<LoginView> {
    public void sendcode(String phone) {
        getNetData(RetrofitManager.get().create(ApiService.class).sendcode(phone, "loginCode"),
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

    public void login(String phone, String password) {
        getNetData(RetrofitManager.get().create(ApiService.class).login(phone, password),
                new ApiObserver<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean bean) {
                        getView().returnLogin(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }

}
