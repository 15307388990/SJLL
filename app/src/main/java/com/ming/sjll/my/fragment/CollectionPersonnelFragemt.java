package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.my.activity.HomeageActivity;
import com.ming.sjll.my.adapter.CollectionPersonelAdapter;
import com.ming.sjll.my.bean.ColletionPersenterBean;
import com.ming.sjll.my.presenter.ColletionPersonnelPresenter;
import com.ming.sjll.my.view.ColletionPersonnelView;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 收藏 人员
 */
public class CollectionPersonnelFragemt extends MvpFragment<ColletionPersonnelView, ColletionPersonnelPresenter> implements ColletionPersonnelView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;


    public static CollectionPersonnelFragemt newInstance() {
        CollectionPersonnelFragemt projectManagementFragemt = new CollectionPersonnelFragemt();
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
    protected ColletionPersonnelPresenter createPresenter() {
        return new ColletionPersonnelPresenter();
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
    public void ShowData(ColletionPersenterBean pBean) {
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        CollectionPersonelAdapter collectionPersonelAdapter = new CollectionPersonelAdapter(pBean.getData().getData());
        collectionPersonelAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("uid", pBean.getData().getData().get(position).getUid() + "");
                Tools.jump(getActivity(), HomeageActivity.class, bundle, false);
            }
        });
        recyclerview.setAdapter(collectionPersonelAdapter);

    }
}
