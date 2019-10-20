package com.ming.sjll.projectmanage.fragment;

import android.os.Bundle;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.projectmanage.presenter.ProjectPresenter;
import com.ming.sjll.projectmanage.presenter.ProjectSupplierPresenter;
import com.ming.sjll.projectmanage.view.ProjectView;
import com.ming.sjll.projectmanage.view.SupplierView;

/**
 * @author luoming
 *created at 2019-10-12 14:35
 * 项目管理供应商界面
*/
public class ProjectSupplierFragemt extends MvpFragment<SupplierView, ProjectSupplierPresenter> implements ProjectView {


    public static ProjectSupplierFragemt newInstance() {
        return new ProjectSupplierFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_project_supplier);
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
