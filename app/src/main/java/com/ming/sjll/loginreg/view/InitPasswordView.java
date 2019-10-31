package com.ming.sjll.loginreg.view;


import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.bean.RegistereBean;

public interface InitPasswordView extends MvpView {

    void returnCode(BaseBean baseBean);

    void returnRegistere(RegistereBean baseBean);
}
