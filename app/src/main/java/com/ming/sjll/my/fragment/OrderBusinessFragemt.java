package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.my.presenter.OrderBusinessPresenter;
import com.ming.sjll.purchaser.adapter.ProjectManagementAdapter;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.view.ProjectManagementView;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 我的订单*业务
 */
public class OrderBusinessFragemt extends MvpFragment<ProjectManagementView, OrderBusinessPresenter> implements ProjectManagementView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.rb_jinxinzhong)
    RadioButton rbJinxinzhong;
    @BindView(R.id.rb_weikaishi)
    RadioButton rbWeikaishi;
    @BindView(R.id.rb_yiwancheng)
    RadioButton rbYiwancheng;
    @BindView(R.id.rb_yiquxiao)
    RadioButton rbYiquxiao;


    public static OrderBusinessFragemt newInstance() {
        OrderBusinessFragemt projectManagementFragemt = new OrderBusinessFragemt();
        return projectManagementFragemt;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_order_business_recycle);
        initOnClick();
    }

    private void initOnClick() {
        rbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getBusiness("0");
            }
        });
        rbJinxinzhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getBusiness("1");
            }
        });
        rbWeikaishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getBusiness("2");
            }
        });
        rbYiwancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getBusiness("3");
            }
        });
        rbYiquxiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getBusiness("4");
            }
        });


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected OrderBusinessPresenter createPresenter() {
        return new OrderBusinessPresenter();
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
    public void onDestroyView() {
        super.onDestroyView();
    }


    @Override
    public void ShowData(ProjectManagementBean bean) {
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(new ProjectManagementAdapter(bean.getData().getData()));

    }
}
