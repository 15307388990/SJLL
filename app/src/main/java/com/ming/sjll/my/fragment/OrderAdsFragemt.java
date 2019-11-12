package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.my.bean.AdsBean;
import com.ming.sjll.my.presenter.OrderAdsPresenter;
import com.ming.sjll.my.presenter.OrderBusinessPresenter;
import com.ming.sjll.my.view.AdsView;
import com.ming.sjll.purchaser.adapter.ProjectManagementAdapter;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
import com.ming.sjll.purchaser.view.ProjectManagementView;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 我的订单*投广
 */
public class OrderAdsFragemt extends MvpFragment<AdsView, OrderAdsPresenter> implements AdsView {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.rb_all)
    RadioButton rbAll;
    @BindView(R.id.rb_jinxinzhong)
    RadioButton rbJinxinzhong;
    @BindView(R.id.rb_weikaishi)
    RadioButton rbWeikaishi;
    @BindView(R.id.rb_yiwancheng)
    RadioButton rbYiwancheng;
    @BindView(R.id.rb_yiquxiao)
    RadioButton rbYiquxiao;


    public static OrderAdsFragemt newInstance() {
        OrderAdsFragemt projectManagementFragemt = new OrderAdsFragemt();
        return projectManagementFragemt;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_order_business_recycle);
        initOnClick();
    }

    private void initOnClick() {
        rbAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getAds("0");
            }
        });
        rbJinxinzhong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getAds("1");
            }
        });
        rbWeikaishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getAds("2");
            }
        });
        rbYiwancheng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getAds("3");
            }
        });
        rbYiquxiao.setVisibility(View.GONE);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    protected OrderAdsPresenter createPresenter() {
        return new OrderAdsPresenter();
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
    public void ShowData(AdsBean pBean) {
//        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerview.setAdapter(new ProjectManagementAdapter(bean.getData().getData()));
    }
}
