package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.purchaser.presenter.ProjectSupplierPresenter;
import com.ming.sjll.purchaser.view.ProjectView;
import com.ming.sjll.purchaser.view.SupplierView;

/**
 * @author luoming
 *created at 2019-10-14 10:32
 * 采购商视觉
*/
public class PurchaserVisualFragemt extends MvpFragment<SupplierView, ProjectSupplierPresenter> implements ProjectView {


    public static PurchaserVisualFragemt newInstance() {
        return new PurchaserVisualFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_purchaser_visual);
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
