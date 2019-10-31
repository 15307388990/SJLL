package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.my.bean.CompanyBean;
import com.ming.sjll.my.presenter.MyPresenter;
import com.ming.sjll.my.view.MyView;
import com.ming.sjll.view.CircleImageView;

import androidx.annotation.Nullable;
import butterknife.BindView;


public class MyFragemt extends MvpFragment<MyView, MyPresenter> implements MyView {


    @BindView(R.id.iv_bg)
    ImageView ivBg;
    @BindView(R.id.iv_head)
    CircleImageView ivHead;
    @BindView(R.id.iv_sex)
    ImageView ivSex;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
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

    public static MyFragemt newInstance() {
        return new MyFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_my);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.getIsApprove();
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
}
