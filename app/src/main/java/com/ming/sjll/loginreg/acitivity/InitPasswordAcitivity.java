package com.ming.sjll.loginreg.acitivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.MyCountTimer;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.bean.RegistereBean;
import com.ming.sjll.loginreg.presenter.InitPasswordPresenter;
import com.ming.sjll.loginreg.view.InitPasswordView;

import androidx.annotation.Nullable;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author luoming
 * created at 2019-10-29 10:45
 * 初始化登录密码
 */
public class InitPasswordAcitivity extends MvpActivity<InitPasswordView, InitPasswordPresenter> implements InitPasswordView {


    String iphone, code;
    @BindView(R.id.title_bar_IvLeft)
    ImageView titleBarIvLeft;
    @BindView(R.id.et_pssword1)
    EditText etPssword1;
    @BindView(R.id.et_pssword2)
    EditText etPssword2;
    @BindView(R.id.tv_registered)
    TextView tvRegistered;
    @BindView(R.id.tv_phone)
    TextView tvPhone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init_password);
        ButterKnife.bind(this);
        initView();

    }


    private void initView() {
        iphone = getIntent().getStringExtra("phone");
        code = getIntent().getStringExtra("code");
        tvPhone.setText("+86  " + Tools.formatPhone(iphone));
        tvRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.register(iphone, etPssword1.getText().toString().trim(), etPssword2.getText().toString().trim(), code);
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
    protected InitPasswordPresenter createPresenter() {
        return new InitPasswordPresenter();
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

    }

    @Override
    public void returnRegistere(RegistereBean baseBean) {
        Intent intent = new Intent(InitPasswordAcitivity.this, LoginAcitivity.class);
        intent.putExtra("phone", baseBean.getBean().getPhone());
        startActivity(intent);
    }

}
