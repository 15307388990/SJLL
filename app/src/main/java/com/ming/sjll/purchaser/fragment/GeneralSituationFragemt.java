package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.purchaser.adapter.Generaldapter;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.purchaser.presenter.GeneralPresenter;
import com.ming.sjll.purchaser.view.GeneralView;
import com.ming.sjll.purchaser.view.PublishProjectView;
import com.ming.sjll.view.SpinnerView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 概况
 */
public class GeneralSituationFragemt extends MvpFragment<GeneralView, GeneralPresenter> implements GeneralView {
    @BindView(R.id.ns_fangan)
    SpinnerView nsFangan;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    private PublishProjectView publishProjectView;
    private Generaldapter generaldapter;
    private OccupationBean qccBean;


    public static GeneralSituationFragemt newInstance() {
        return new GeneralSituationFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_general_situation);
        ininSpiner();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getOccupation();
    }

    private void ininSpiner() {
        List<String> xuyaoList = new LinkedList<>(Arrays.asList("需要", "不需要"));
        nsFangan.attachDataSource(xuyaoList);

    }

    public void SetPublishProjectView(PublishProjectView publishProjectView) {
        this.publishProjectView = publishProjectView;
    }

    @Override
    protected GeneralPresenter createPresenter() {
        return new GeneralPresenter();
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
    public void getOccupation(OccupationBean bean) {
        qccBean=bean;
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        generaldapter = new Generaldapter(bean.getData());
        recyclerview.setAdapter(generaldapter);
        generaldapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (qccBean.getData().get(position).isSelected()) {
                    qccBean.getData().get(position).setSelected(false);
                } else {
                    qccBean.getData().get(position).setSelected(true);
                }
                generaldapter.setNewData(qccBean.getData());
            }
        });
    }

}
