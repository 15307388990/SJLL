package com.ming.sjll.loginreg.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.loginreg.bean.RegistereBean;
import com.ming.sjll.loginreg.view.LoginView;
import com.ming.sjll.loginreg.view.RegisteredView;
import com.ming.sjll.purchaser.bean.AreaBean;

public class RegisteredPresenter extends MvpPresenter<RegisteredView> {
    public void sendcode(String phone) {
        getNetData(RetrofitManager.get().create(ApiService.class).sendcode(phone, "registerCode"),
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

}
