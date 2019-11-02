package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.FullLinearLayout;
import com.ming.sjll.my.adapter.PersonalDataAdapter;
import com.ming.sjll.my.bean.CompanyBean;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.my.presenter.MyPresenter;
import com.ming.sjll.my.presenter.PersonalDataPresenter;
import com.ming.sjll.my.view.MyView;
import com.ming.sjll.my.view.PersonalDataView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-11-01 11:37
 * 个人中心，个人资料
 */

public class PersonalDataFragemt extends MvpFragment<PersonalDataView, PersonalDataPresenter> implements PersonalDataView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    public static PersonalDataFragemt newInstance() {
        return new PersonalDataFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_recycle);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getWorksList();
    }

    @Override
    protected PersonalDataPresenter createPresenter() {
        return new PersonalDataPresenter();
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


    @Override
    public void ShowData(PersonalDateBean pbean) {
        recyclerview.setLayoutManager(new FullLinearLayout(getActivity(),1){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        recyclerview.setAdapter(new PersonalDataAdapter(pbean.getData().getData()));

    }
}
