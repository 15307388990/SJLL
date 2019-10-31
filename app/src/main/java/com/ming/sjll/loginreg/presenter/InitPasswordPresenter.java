package com.ming.sjll.loginreg.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.bean.RegistereBean;
import com.ming.sjll.loginreg.view.InitPasswordView;
import com.ming.sjll.loginreg.view.VerificationView;

public class InitPasswordPresenter extends MvpPresenter<InitPasswordView> {
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
    public void register(String phone, String password, String repassword, String code) {
        getNetData(RetrofitManager.get().create(ApiService.class).register(phone, password, code, repassword),
                new ApiObserver<RegistereBean>() {
                    @Override
                    public void onSuccess(RegistereBean bean) {
                        getView().returnRegistere(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }


}
