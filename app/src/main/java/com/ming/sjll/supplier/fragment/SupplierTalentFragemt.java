package com.ming.sjll.supplier.fragment;

import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.supplier.adapter.MaybeLikedapter;
import com.ming.sjll.supplier.adapter.Talentdapter;
import com.ming.sjll.supplier.adapter.XinquAdapter;
import com.ming.sjll.supplier.bean.MaybeLikBean;
import com.ming.sjll.supplier.bean.TalentPushBean;
import com.ming.sjll.supplier.presenter.TalentPresenter;
import com.ming.sjll.supplier.view.TalentView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 供应商达人
 */
public class SupplierTalentFragemt extends MvpFragment<TalentView, TalentPresenter> implements TalentView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.recyclerview2)
    RecyclerView recyclerview2;


    public static SupplierTalentFragemt newInstance() {
        return new SupplierTalentFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_supplier_talent);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.talentPush("2");
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
        recyclerview.setAdapter(new Talentdapter(bean.getData()));
    }

    @Override
    public void maybeLike(MaybeLikBean bean) {
        recyclerview2.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview2.setAdapter(new XinquAdapter(bean.getData()));
    }
}
