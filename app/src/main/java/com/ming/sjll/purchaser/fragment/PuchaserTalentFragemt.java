package com.ming.sjll.purchaser.fragment;

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
import com.ming.sjll.supplier.adapter.Talentdapter;
import com.ming.sjll.supplier.adapter.XinquAdapter;
import com.ming.sjll.supplier.bean.MaybeLikBean;
import com.ming.sjll.supplier.bean.TalentPushBean;
import com.ming.sjll.supplier.presenter.TalentPresenter;
import com.ming.sjll.supplier.view.TalentView;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 采购商达人
 */
public class PuchaserTalentFragemt extends MvpFragment<TalentView, TalentPresenter> implements TalentView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.recyclerview2)
    RecyclerView recyclerview2;


    public static PuchaserTalentFragemt newInstance() {
        return new PuchaserTalentFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_supplier_talent);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.talentPush("1");
    }

    @Override
    protected TalentPresenter createPresenter() {
        return new TalentPresenter();
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
    public void talentPush(TalentPushBean bean) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(linearLayoutManager);
        Talentdapter talentdapter = new Talentdapter(bean.getData());
        recyclerview.setAdapter(talentdapter);



    }

    @Override
    public void maybeLike(MaybeLikBean bean) {
        recyclerview2.setLayoutManager(new LinearLayoutManager(getActivity()));
        XinquAdapter xinquAdapter = new XinquAdapter(bean.getData(), new XinquAdapter.AddFocus() {
            @Override
            public void addFocus(String focus_user_id) {
                mPresenter.addFocus(focus_user_id);
            }
        });
        recyclerview2.setAdapter(xinquAdapter);
    }
}
