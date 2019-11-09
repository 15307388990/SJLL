package com.ming.sjll.my.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityRecycleBinding;
import com.ming.sjll.databinding.HomePageHeadItemBinding;
import com.ming.sjll.my.adapter.Companydapter;
import com.ming.sjll.my.adapter.HomePageDataAdapter;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.dialog.EditorDialog;
import com.ming.sjll.my.dialog.HomePageDialog;
import com.ming.sjll.my.presenter.ComplainPresenter;
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
        binding.setTitleViewModel(new ToolbarViewModel());
        binding.titleBar.titleBarContentView.setBackgroundColor(getResources().getColor(R.color.transparent));
        binding.titleBar.titleBarIvLeft.setImageResource(R.mipmap.ic_top_with_back);
        binding.titleBar.titleBarIvRight.setImageResource(R.mipmap.ic_top_with_menu);
        binding.titleBar.titleBarIvRight.setVisibility(View.VISIBLE);
        binding.titleBar.titleBarIvRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomePageDialog.newInstance().setOnClickListener(new HomePageDialog.OnClickListener() {
                    @Override
                    public void Collection() {
                        if (pBean != null) {
                            mPresenter.collectuser();
                        }

                    }

                    @Override
                    public void Report() {
                        Bundle bundle = new Bundle();
                        bundle.putString(ComplainPresenter.REPORTUID, getIntent().getStringExtra("uid"));
                        Tools.jump(HomeageActivity.this, ComplainActivity.class, bundle, false);

                    }
                }).show(HomeageActivity.this);
            }
        });
    }

    @Override
    public void ShowData(HomePageBean pBean) {
        this.pBean = pBean;
        userInfoBean = pBean.getData().getUserInfo();
        companyInfoBean = pBean.getData().getCompanyInfo();

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
        //头部信息
        initHead();
        //收藏
        initHeart();
        if (pBean.getData().getIs_approve() == 2) {
            headBinding.tvCertification.setText("平台认证");
            headBinding.llCampany.llCampany.setVisibility(View.VISIBLE);
            headBinding.llUser.llUser.setVisibility(View.GONE);
            //公司
            initCampany();
        } else {
            headBinding.llCampany.llCampany.setVisibility(View.GONE);
            headBinding.llUser.llUser.setVisibility(View.VISIBLE);
            //个人
            headBinding.tvCertification.setText("平台认证");
            if (pBean.getData().getIs_approve() == 0) {
                //没有认证的个人
                headBinding.tvCertification.setVisibility(View.GONE);
                headBinding.ivCertification.setVisibility(View.GONE);
            }
            initUer();
        }
        binding.recyclerview.setScrollingTouchSlop(0);


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
        headBinding.tvName.setText(userInfoBean.getName());
        headBinding.tvNumber.setText(userInfoBean.getCollect_num() + "");
        headBinding.flowtag.addTags(userInfoBean.getTags());

    }

    private void initHeart() {
        if (userInfoBean.getIs_collect() == 1) {
            headBinding.ivHeart.setImageResource(R.mipmap.ic_my_heart);
        } else {
            headBinding.ivHeart.setImageResource(R.mipmap.ic_home_page_heart);
        }
        headBinding.tvNumber.setText(userInfoBean.getCollect_num() + "");
    }

    //初始化个人信息
    private void initUer() {
        headBinding.llUser.tvUserNickname.setText(userInfoBean.getName());
        headBinding.llUser.tvUserCompany.setText(userInfoBean.getCompany_name());
        headBinding.llUser.tvUserCompensation.setText(userInfoBean.getPayment_hour() + "/时  " + userInfoBean.getPayment_day() + "/天");
        StringBuffer occpations = new StringBuffer();
        for (String occpation : userInfoBean.getOccupation()) {
            occpations.append(occpation + "  ");
        }
        headBinding.llUser.tvUserProfessional.setText(occpations);

    }

    //初始化公司信息
    private void initCampany() {
        headBinding.llCampany.tvCampanyAdds.setText(companyInfoBean.getAddress());
        headBinding.llCampany.tvCampanyJiancheng.setText(companyInfoBean.getShort_company_name());
        headBinding.llCampany.tvCampanyJianjie.setText(companyInfoBean.getDescribe());
        headBinding.llCampany.tvCampanyName.setText(companyInfoBean.getFull_company_name());
        headBinding.llCampany.tvCampanyQianming.setText(companyInfoBean.getSignature());
        StringBuffer professionals = new StringBuffer();
        for (HomePageBean.DataBean.CompanyInfoBean.BusinessBean professional : companyInfoBean.getBusiness()) {
            professionals.append(professional.getTitle() + "  ");
        }
        headBinding.llCampany.tvCampanyProfessional.setText(professionals);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        headBinding.llCampany.recyclerview.setLayoutManager(linearLayoutManager);
        headBinding.llCampany.recyclerview.setAdapter(new Companydapter(companyInfoBean.getShowCase()));
    }

    @Override
    public void workCollect(BaseBean bean) {
        int collectNum = pBean.getData().getWork().get(index).getCollect_num();
        //点赞
        if (pBean.getData().getWork().get(index).getIs_collect() == 1) {
            pBean.getData().getWork().get(index).setIs_collect(0);
            pBean.getData().getWork().get(index).setCollect_num(collectNum - 1);
        } else {
            pBean.getData().getWork().get(index).setIs_collect(1);
            pBean.getData().getWork().get(index).setCollect_num(collectNum + 1);
        }
        homePageDataAdapter.setNewData(pBean.getData().getWork());

    }

    @Override
    public void collectuser(BaseBean bean) {
        if (userInfoBean.getIs_collect() == 1) {
            userInfoBean.setCollect_num(userInfoBean.getCollect_num() - 1);
            userInfoBean.setIs_collect(0);
        } else {
            userInfoBean.setCollect_num(userInfoBean.getCollect_num() + 1);
            userInfoBean.setIs_collect(1);
        }
        initHeart();
    }
}
