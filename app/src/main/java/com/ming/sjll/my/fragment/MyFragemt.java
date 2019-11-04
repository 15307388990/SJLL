package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.my.bean.CompanyBean;
import com.ming.sjll.my.presenter.MyPresenter;
import com.ming.sjll.my.view.MyView;
import com.ming.sjll.purchaser.fragment.CityFragemt;
import com.ming.sjll.purchaser.fragment.GeneralSituationFragemt;
import com.ming.sjll.purchaser.fragment.TimerFragemt;
import com.ming.sjll.view.CircleImageView;
import com.ming.sjll.view.HoldTabScrollView;
import com.ming.sjll.view.WrapContentHeightViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MyFragemt extends MvpFragment<MyView, MyPresenter> implements MyView, HoldTabScrollView.OnHoldTabScrollViewScrollChanged {


    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.iv_sex)
    ImageView ivSex;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_number)
    TextView tvNumber;
    @BindView(R.id.tv_work)
    TextView tvWork;
    @BindView(R.id.tv_personal)
    TextView tvPersonal;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_wallet)
    TextView tvWallet;
    @BindView(R.id.iv_certification)
    ImageView ivCertification;
    @BindView(R.id.tv_certification)
    TextView tvCertification;
    @BindView(R.id.ll_center)
    LinearLayout llCenter;
    @BindView(R.id.rl_center)
    RelativeLayout rlCenter;
    @BindView(R.id.rl_top)
    RelativeLayout rlTop;
    @BindView(R.id.scroll_view)
    HoldTabScrollView scrollView;
    @BindView(R.id.viewpager)
    WrapContentHeightViewPager viewpager;
    List<Fragment> fragmentList;


    private PersonalWorkFragemt personalWorkFragemt;
    private PersonalDataFragemt personalDataFragemt;
    private Fragment[] mFragments;

    private boolean canJump = true;

    public static MyFragemt newInstance() {
        return new MyFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_my);
        initView();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getIsApprove();
        scrollView.setOnObservableScrollViewScrollChanged(this);
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

    @Override
    public void ShowData(CompanyBean companyBean) {
        ImageHelper.displayBackground(ivBg, Constant.BASE_API + companyBean.getData().getDefault_avatar(), R.mipmap.ic_launcher);
        ImageHelper.displayBackground(ivHead, Constant.BASE_API + companyBean.getData().getCover_img(), R.mipmap.ic_launcher);
        tvName.setText(companyBean.getData().getCompany_name());
        tvNumber.setText(companyBean.getData().getCollect_num() + "");
        if (companyBean.getData().getIs_approve() == 2) {
            //公司认证
            tvPersonal.setVisibility(View.GONE);
            tvCompany.setVisibility(View.VISIBLE);

        } else {
            //个人认证
            tvPersonal.setVisibility(View.VISIBLE);
            tvCompany.setVisibility(View.GONE);
        }
        //是否显示平台验证
        if (companyBean.getData().getIs_approve() == 0) {
            tvCertification.setVisibility(View.GONE);
            tvCertification.setVisibility(View.GONE);
        } else {
            tvCertification.setVisibility(View.VISIBLE);
            tvCertification.setVisibility(View.VISIBLE);
        }
        //性别
        if (companyBean.getData().getSex() == 1) {
            ivSex.setImageResource(R.mipmap.ic_sex_girl);
        } else {
            ivSex.setImageResource(R.mipmap.ic_sex_man);
        }


    }

//    @Override
//    public void setUserVisibleHint(boolean isVisibleToUser) {
//        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisibleToUser) {
//            //获取HeaderView的高度，当滑动大于等于这个高度的时候，需要把tabView移除当前布局，放入到外层布局
//            mHeight = rlCenter.getTop();
//        }
//    }

    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(PersonalWorkFragemt.newInstance());
        fragmentList.add(PersonalDataFragemt.newInstance());
        viewpager.setAdapter(new Adaper(getChildFragmentManager()));

        tvWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(0);
            }
        });
        tvPersonal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(1);
            }
        });
        tvCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewpager.setCurrentItem(1);
            }
        });
    }


    @Override
    public void onObservableScrollViewScrollChanged(int l, int t, int oldl, int oldt) {
        if (t >= 1000) {
            if (llCenter.getParent() != rlTop) {
                rlCenter.removeView(llCenter);
                rlTop.addView(llCenter);
                canJump = false;
            }
        } else {
            if (llCenter.getParent() != rlCenter) {
                rlTop.removeView(llCenter);
                rlCenter.addView(llCenter);
                canJump = true;
            }
        }
    }

    class Adaper extends FragmentStatePagerAdapter {
        public Adaper(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }
}
