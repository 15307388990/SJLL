package com.ming.sjll.loginreg.acitivity;

import android.os.Bundle;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.loginreg.presenter.LoginPresenter;
import com.ming.sjll.loginreg.presenter.RegisteredPresenter;
import com.ming.sjll.loginreg.view.LoginView;
import com.ming.sjll.loginreg.view.RegisteredView;

import androidx.annotation.Nullable;

/**
 * @author luoming
 * created at 2019-10-29 10:45
 * 注册
 */
public class RegisteredAcitivity extends MvpActivity<RegisteredView, RegisteredPresenter> implements RegisteredView {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
    }

    @Override
    protected RegisteredPresenter createPresenter() {
        return new RegisteredPresenter();
    }

    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

    }

}
