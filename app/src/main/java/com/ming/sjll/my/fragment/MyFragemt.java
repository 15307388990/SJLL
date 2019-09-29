package com.ming.sjll.my.fragment;

import android.os.Bundle;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.my.presenter.MyPresenter;
import com.ming.sjll.my.view.MyView;


public class MyFragemt extends MvpFragment<MyView, MyPresenter> implements MyView {


    public static MyFragemt newInstance() {
        return new MyFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_project);
    }

    @Override
    protected MyPresenter createPresenter() {
        return new MyPresenter();
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
