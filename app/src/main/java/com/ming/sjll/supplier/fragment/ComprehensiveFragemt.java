package com.ming.sjll.supplier.fragment;

import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.supplier.adapter.Comprehendapter;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.presenter.ComprehensivePresenter;
import com.ming.sjll.supplier.view.ComprehensiveView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 综合
 */
public class ComprehensiveFragemt extends MvpFragment<ComprehensiveView, ComprehensivePresenter> implements ComprehensiveView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    public static ComprehensiveFragemt newInstance() {
        return new ComprehensiveFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_comprehensive);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getProjectIntegrated();
    }


    @Override
    protected ComprehensivePresenter createPresenter() {
        return new ComprehensivePresenter();
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
    public void setProjectIntegrated(ComprehenBean bean) {
        recyclerview.setNestedScrollingEnabled(false);
        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerview.setAdapter(new Comprehendapter(bean.getData().getData()));

    }
}
