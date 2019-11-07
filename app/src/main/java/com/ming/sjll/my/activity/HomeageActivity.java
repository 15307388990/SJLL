package com.ming.sjll.my.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.FullLinearLayout;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityRecycleBinding;
import com.ming.sjll.my.adapter.HomePageDataAdapter;
import com.ming.sjll.my.adapter.PersonalDataAdapter;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.my.dialog.EditorDataDialog;
import com.ming.sjll.my.dialog.EditorDialog;
import com.ming.sjll.my.presenter.HomeagePresenter;
import com.ming.sjll.my.view.HomeageDataView;

/**
 * 个人主页
 */

public class HomeageActivity extends MvpActivity<HomeageDataView, HomeagePresenter> implements HomeageDataView {
    private ActivityRecycleBinding binding;
    private int index;
    private HomePageDataAdapter homePageDataAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle);
        //设置标题
        binding.titleBar.titleBarContentView.setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    @Override
    public void ShowData(PersonalDateBean pBean) {



        binding.recyclerview.setLayoutManager(new FullLinearLayout(HomeageActivity.this, 1) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        homePageDataAdapter = new HomePageDataAdapter(pBean.getData().getData());
        binding.recyclerview.setAdapter(homePageDataAdapter);
        homePageDataAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.ll_heart) {
                    //点赞
                    index = position;
                    mPresenter.workCollect(pBean.getData().getData().get(position).getId());
                }
            }
        });

    }

    @Override
    public void workCollect(BaseBean bean) {
        //点赞


    }
}
