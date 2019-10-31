package com.ming.sjll.loginreg.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.presenter.LoginPresenter;
import com.ming.sjll.loginreg.view.LoginView;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author luoming
 * created at 2019-10-29 10:45
 * 登录
 */
public class LoginAcitivity extends MvpActivity<LoginView, LoginPresenter> implements LoginView {


    @BindView(R.id.ll_layout)
    LinearLayout llLayout;
    @BindView(R.id.et_pssword)
    EditText etPssword;
    @BindView(R.id.tv_zhuce)
    TextView tvZhuce;
    @BindView(R.id.tv_wangji)
    TextView tvWangji;
    @BindView(R.id.rl_pssword)
    RelativeLayout rlPssword;
    @BindView(R.id.tv_btn1)
    TextView tvBtn1;
    @BindView(R.id.tv_btn2)
    TextView tvBtn2;
    @BindView(R.id.et_phone)
    EditText etPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tvBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tvBtn1.getText().toString().equals("快捷登录")) {
                    tvBtn1.setText("账号登录");
                    tvBtn2.setText("快捷登录");
                    rlPssword.setVisibility(View.GONE);
                } else if (tvBtn1.getText().toString().equals("账号登录")) {
                    tvBtn1.setText("快捷登录");
                    tvBtn2.setText("账号登录");
                    rlPssword.setVisibility(View.VISIBLE);
                }

            }
        });
        tvBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tvBtn2.getText().toString().equals("快捷登录")) {
                    //发送验证码
                    mPresenter.sendcode(etPhone.getText().toString());
                } else if (tvBtn2.getText().toString().equals("账号登录")) {
                    //登录
                    mPresenter.login(etPhone.getText().toString().trim(), etPssword.getText().toString().trim());
                }

            }
        });
        tvZhuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.jump(LoginAcitivity.this, RegisteredAcitivity.class, true);
            }
        });
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter();
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
    public void returnLogin(LoginBean baseBean) {
        mSavePreferencesData.putStringData("token", baseBean.getBean().getToken());
    }

    @Override
    public void returnCode(BaseBean baseBean) {
        Intent intent = new Intent(LoginAcitivity.this, VerificationCodeAcitivity.class);
        intent.putExtra("iphone", etPhone.getText().toString().trim());
        startActivity(intent);
    }
}
