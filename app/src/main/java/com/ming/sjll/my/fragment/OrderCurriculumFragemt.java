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
import com.ming.sjll.my.adapter.OrderCurriculumAdapter;
import com.ming.sjll.my.bean.CurriculumBean;
import com.ming.sjll.my.presenter.OrderBusinessPresenter;
import com.ming.sjll.my.presenter.OrderCurriculumPresenter;
import com.ming.sjll.my.view.CurriculumView;
import com.ming.sjll.purchaser.adapter.ProjectManagementAdapter;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.view.ProjectManagementView;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 我的订单*课程
 */
public class OrderCurriculumFragemt extends MvpFragment<CurriculumView, OrderCurriculumPresenter> implements CurriculumView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;


    public static OrderCurriculumFragemt newInstance() {
        OrderCurriculumFragemt projectManagementFragemt = new OrderCurriculumFragemt();
        return projectManagementFragemt;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_recycle);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected OrderCurriculumPresenter createPresenter() {
        return new OrderCurriculumPresenter();
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
    public void ShowData(CurriculumBean pBean) {
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(new OrderCurriculumAdapter(pBean.getData().getData()));

    }
}
