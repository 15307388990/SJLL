package com.ming.sjll.loginreg.view;


import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.loginreg.bean.LoginBean;

public interface LoginView extends MvpView {
    void returnLogin(LoginBean baseBean);

    void returnCode(BaseBean baseBean);
}
