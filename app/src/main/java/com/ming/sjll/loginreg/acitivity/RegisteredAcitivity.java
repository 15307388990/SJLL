package com.ming.sjll.loginreg.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.MyCountTimer;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.loginreg.bean.RegistereBean;
import com.ming.sjll.loginreg.presenter.RegisteredPresenter;
import com.ming.sjll.loginreg.view.RegisteredView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author luoming
 * created at 2019-10-29 10:45
 * 注册
 */
public class RegisteredAcitivity extends MvpActivity<RegisteredView, RegisteredPresenter> implements RegisteredView {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_btn1)
    TextView tvBtn1;
    @BindView(R.id.tv_btn2)
    TextView tvBtn2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        tvBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBtn1.getText().toString().trim().equals("发送\n验证码") || tvBtn1.getText().toString().equals("重新发送")) {
                    mPresenter.sendcode(etPhone.getText().toString().trim());
                }
            }
        });
        tvBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etPhone.getText().toString().trim().length() > 10 && etCode.getText().toString().trim().length() > 3) {
                    Intent intent = new Intent(RegisteredAcitivity.this, InitPasswordAcitivity.class);
                    intent.putExtra("phone", etPhone.getText().toString().trim());
                    intent.putExtra("code", etCode.getText().toString().trim());
                    startActivity(intent);
                }

            }
        });

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
        ToastShow.s(msg);

    }

    @Override
    public void returnCode(BaseBean baseBean) {
        MyCountTimer myCountTimer = new MyCountTimer(RegisteredAcitivity.this, tvBtn1, "重新发送", R.color.LL_bdc5e4, R.color.LL_bdc5e4);
        myCountTimer.start();
    }

    @Override
    public void successful(BaseBean baseBean) {
        finish();
    }

}
