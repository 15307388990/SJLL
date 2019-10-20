package com.ming.sjll.show.fragment;

import android.os.Bundle;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.projectmanage.presenter.ProjectPresenter;
import com.ming.sjll.projectmanage.view.ProjectView;
import com.ming.sjll.show.presenter.ShowPresenter;
import com.ming.sjll.show.view.ShowView;


public class ShowFragemt extends MvpFragment<ShowView, ShowPresenter> implements ShowView {


    public static ShowFragemt newInstance() {
        return new ShowFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_order);
    }

    @Override
    protected ShowPresenter createPresenter() {
        return new ShowPresenter();
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
