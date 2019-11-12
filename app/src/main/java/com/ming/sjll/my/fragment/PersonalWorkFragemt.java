package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.LinearLayout;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.activity.ApplicationInAcitivity;
import com.ming.sjll.my.activity.MyorderAcitivity;
import com.ming.sjll.my.bean.CompanyBean;
import com.ming.sjll.my.presenter.MyPresenter;
import com.ming.sjll.my.view.MyView;

import butterknife.BindView;


/**
 * @author luoming
 * created at 2019-11-01 11:37
 * 个人中心，工作
 */

public class PersonalWorkFragemt extends MvpFragment<MyView, MyPresenter> implements MyView {


    @BindView(R.id.ll_join)
    LinearLayout llJoin;
    @BindView(R.id.ll_order)
    LinearLayout llOrder;

    public static PersonalWorkFragemt newInstance() {
        return new PersonalWorkFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_work);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getIsApprove();
        initOnclick();
    }

    private void initOnclick() {
        //加入视觉行动
        llJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.jump(getActivity(), ApplicationInAcitivity.class, false);
            }
        });
        //我的订单
        llOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tools.jump(getActivity(), MyorderAcitivity.class, false);
            }
        });
    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
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
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void ShowData(CompanyBean companyBean) {

    }
}
