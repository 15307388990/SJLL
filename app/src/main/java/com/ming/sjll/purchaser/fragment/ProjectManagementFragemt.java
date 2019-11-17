package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.purchaser.adapter.Generaldapter;
import com.ming.sjll.purchaser.adapter.ProjectManagementAdapter;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.presenter.GeneralPresenter;
import com.ming.sjll.purchaser.presenter.ProjectManagementPresenter;
import com.ming.sjll.purchaser.view.GeneralView;
import com.ming.sjll.purchaser.view.ProjectManagementView;
import com.ming.sjll.purchaser.view.PublishProjectView;
import com.ming.sjll.view.SpinnerView;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 项目管理
 */
public class ProjectManagementFragemt extends MvpFragment<ProjectManagementView, ProjectManagementPresenter> implements ProjectManagementView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;


    public static ProjectManagementFragemt newInstance(String type) {
        ProjectManagementFragemt projectManagementFragemt = new ProjectManagementFragemt();
        Bundle bundle=new Bundle();
        bundle.putString("type",type);
        projectManagementFragemt.setArguments(bundle);
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
    protected ProjectManagementPresenter createPresenter() {
        return new ProjectManagementPresenter();
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
