package com.ming.sjll.my.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.FullLinearLayout;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityRecycleBinding;
import com.ming.sjll.databinding.HomePageHeadItemBinding;
import com.ming.sjll.my.adapter.HomePageDataAdapter;
import com.ming.sjll.my.adapter.PersonalDataAdapter;
import com.ming.sjll.my.bean.HomePageBean;
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
    private HomePageHeadItemBinding headBinding;
    private HomePageBean pBean;
    private HomePageBean.DataBean.UserInfoBean userInfoBean;
    private HomePageBean.DataBean.CompanyInfoBean companyInfoBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle);
        //设置标题
        binding.titleBar.titleBarContentView.setBackgroundColor(getResources().getColor(R.color.transparent));
    }

    @Override
    public void ShowData(HomePageBean pBean) {
        this.pBean = pBean;

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        homePageDataAdapter = new HomePageDataAdapter(pBean.getData().getWork());
        binding.recyclerview.setAdapter(homePageDataAdapter);
        homePageDataAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.ll_heart) {
                    //点赞
                    index = position;
                    mPresenter.workCollect(pBean.getData().getWork().get(position).getId());
                }
            }
        });
        headBinding = HomePageHeadItemBinding.inflate(getLayoutInflater());
        homePageDataAdapter.addHeaderView(headBinding.getRoot());
        initHead();


    }

    //头部数据初始化
    private void initHead() {
        //设置背景图片
        ImageHelper.displayBackground(headBinding.ivBg, Constant.BASE_API + userInfoBean.getDefault_avatar(), R.mipmap.ic_launcher);
        ImageHelper.displayBackground(headBinding.ivHead, Constant.BASE_API + userInfoBean.getCover_img(), R.mipmap.ic_launcher);
        if (userInfoBean.getSex() == 1) {
            headBinding.ivSex.setImageResource(R.mipmap.ic_sex_girl);
        } else {
            headBinding.ivSex.setImageResource(R.mipmap.ic_sex_man);
        }
        headBinding.tvName.setText(userInfoBean.getCompany_name());
        headBinding.tvNumber.setText(userInfoBean.getCollect_num());
        headBinding.flowtag.addTags(userInfoBean.getTags());

    }


    @Override
    public void workCollect(BaseBean bean) {
        //点赞


    }
}
