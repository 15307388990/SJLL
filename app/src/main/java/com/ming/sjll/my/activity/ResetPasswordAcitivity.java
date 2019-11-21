package com.ming.sjll.my.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.MyCountTimer;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.databinding.ActivityRePasswordBinding;
import com.ming.sjll.loginreg.acitivity.InitPasswordAcitivity;
import com.ming.sjll.loginreg.presenter.RegisteredPresenter;
import com.ming.sjll.loginreg.view.RegisteredView;
import com.ming.sjll.my.presenter.ResetPasswordPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author luoming
 * created at 2019-10-29 10:45
 * 重置密码
 */
public class ResetPasswordAcitivity extends MvpActivity<RegisteredView, ResetPasswordPresenter> implements RegisteredView {

    private ActivityRePasswordBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_re_password);
        initView();
    }

    private void initView() {

        binding.tvBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (binding.tvBtn1.getText().toString().trim().equals("发送\n验证码") || binding.tvBtn1.getText().toString().equals("重新发送")) {
                    mPresenter.saveCode();
                }
            }
        });
        binding.tvBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sendcode(binding.etNewPasswrod.getText().toString().trim(),
                        binding.etPassword.getText().toString().trim(), binding.etCode.toString().trim());
            }
        });

    }


    @Override
    public void showLoading(String msg) {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {
        ToastShow.s(msg);

    }

    @Override
    public void returnCode(BaseBean baseBean) {
        MyCountTimer myCountTimer = new MyCountTimer(ResetPasswordAcitivity.this, binding.tvBtn1, "重新发送", R.color.LL_bdc5e4, R.color.LL_bdc5e4);
        myCountTimer.start();
    }

    @Override
    public void successful(BaseBean baseBean) {
        ToastShow.s("重置成功");
        finish();
    }

}
