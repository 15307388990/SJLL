package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.my.adapter.CollectionGoodsAdapter;
import com.ming.sjll.my.bean.ColletionGoodsBean;
import com.ming.sjll.my.presenter.ColletionGoodsPresenter;
import com.ming.sjll.my.presenter.ColletionProjectPresenter;
import com.ming.sjll.my.view.ColletionGoodslView;
import com.ming.sjll.my.view.ColletionProjectlView;
import com.ming.sjll.supplier.adapter.Comprehendapter;
import com.ming.sjll.supplier.bean.ComprehenBean;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 收藏 项目
 */
public class CollectionProjectFragemt extends MvpFragment<ColletionProjectlView, ColletionProjectPresenter> implements ColletionProjectlView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;


    public static CollectionProjectFragemt newInstance() {
        CollectionProjectFragemt projectManagementFragemt = new CollectionProjectFragemt();
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
    protected ColletionProjectPresenter createPresenter() {
        return new ColletionProjectPresenter();
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
    public void ShowData(ComprehenBean pBean) {
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        Comprehendapter comprehendapter=new Comprehendapter(pBean.getData().getData());
        recyclerview.setAdapter(comprehendapter);

    }
}
