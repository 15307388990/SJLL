package com.ming.sjll.loginreg.acitivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.MyCountTimer;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.presenter.VerificationPresenter;
import com.ming.sjll.loginreg.view.VerificationView;

import androidx.annotation.Nullable;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        initView();
        //MyCountTimer countTimer=new MyCountTimer();

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
