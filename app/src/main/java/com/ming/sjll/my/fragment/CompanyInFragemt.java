package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.purchaser.adapter.ProjectManagementAdapter;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.presenter.ProjectManagementPresenter;
import com.ming.sjll.purchaser.view.ProjectManagementView;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 个人入驻
 * 公司入驻
 */
public class CompanyInFragemt extends MvpFragment {
    private String type;

    public static CompanyInFragemt newInstance(String type) {
        CompanyInFragemt projectManagementFragemt = new CompanyInFragemt();
        Bundle bundle = new Bundle();
        bundle.putString("type", type);
        projectManagementFragemt.setArguments(bundle);
        return projectManagementFragemt;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        type = getArguments().getString("type", "0");
        if (type.equals("0")) {
            setContentView(R.layout.fragemt_user_in);
        } else {
            setContentView(R.layout.fragemt_company_in);
        }

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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


}
