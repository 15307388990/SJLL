package com.ming.sjll.projectmanage.fragment;

import android.os.Bundle;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.projectmanage.presenter.ProjectSupplierPresenter;
import com.ming.sjll.projectmanage.view.ProjectView;
import com.ming.sjll.projectmanage.view.PublishProjectView;
import com.ming.sjll.projectmanage.view.SupplierView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 概况
 */
public class GeneralSituationFragemt extends MvpFragment<SupplierView, ProjectSupplierPresenter> implements ProjectView {
    private PublishProjectView publishProjectView;


    public static GeneralSituationFragemt newInstance() {
        return new GeneralSituationFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_general_situation);
    }

    public void SetPublishProjectView(PublishProjectView publishProjectView) {
        this.publishProjectView = publishProjectView;
    }

    @Override
    protected ProjectSupplierPresenter createPresenter() {
        return new ProjectSupplierPresenter();
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

}
