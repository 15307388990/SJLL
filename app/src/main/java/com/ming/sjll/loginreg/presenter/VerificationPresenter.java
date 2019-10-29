package com.ming.sjll.loginreg.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.view.LoginView;
import com.ming.sjll.loginreg.view.VerificationView;

public class VerificationPresenter extends MvpPresenter<VerificationView> {
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
    public void quickLogin(String phone,String code) {
        getNetData(RetrofitManager.get().create(ApiService.class).quickLogin(phone, code),
                new ApiObserver<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean bean) {
                        getView().returnQuickLogin(bean);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);
                    }
                });
    }


}
