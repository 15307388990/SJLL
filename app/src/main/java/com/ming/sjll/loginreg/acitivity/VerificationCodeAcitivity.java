package com.ming.sjll.loginreg.acitivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.MyCountTimer;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.presenter.VerificationPresenter;
import com.ming.sjll.loginreg.view.VerificationView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author luoming
 * created at 2019-10-29 10:45
 * 验证码
 */
public class VerificationCodeAcitivity extends MvpActivity<VerificationView, VerificationPresenter> implements VerificationView {


    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.et_code)
    EditText etCode;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.tv_login)
    TextView tvLogin;

    String iphone;
    @BindView(R.id.title_bar_IvLeft)
    ImageView titleBarIvLeft;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        ButterKnife.bind(this);
        initView();
        initTimer();

    }

    private void initTimer() {
        MyCountTimer countTimer = new MyCountTimer(VerificationCodeAcitivity.this, tvCode,
                "重新发送", R.color.LL_bdc5e4, R.color.LL_bdc5e4);
        countTimer.start();

    }

    private void initView() {
        iphone = getIntent().getStringExtra("iphone");
        tvPhone.setText("+86  " + Tools.formatPhone(iphone));
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.quickLogin(iphone, tvCode.getText().toString().trim());
            }
        });
        tvCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sendcode(iphone);
            }
        });
        titleBarIvLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected VerificationPresenter createPresenter() {
        return new VerificationPresenter();
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

    @Override
    public void returnCode(BaseBean baseBean) {

    }

    @Override
    public void returnQuickLogin(LoginBean baseBean) {
        mSavePreferencesData.putStringData("token", baseBean.getBean().getToken());
    }
}
