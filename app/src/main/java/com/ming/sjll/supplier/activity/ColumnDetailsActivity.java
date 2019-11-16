package com.ming.sjll.supplier.activity;

import android.app.Activity;
import android.content.res.ColorStateList;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luck.picture.lib.PictureSelector;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.databinding.ActivityRecycleBinding;
import com.ming.sjll.databinding.ColumnDetailsBottomItemBinding;
import com.ming.sjll.databinding.ColumnDetailsHeadItemBinding;
import com.ming.sjll.databinding.HomePageHeadItemBinding;
import com.ming.sjll.my.activity.ComplainActivity;
import com.ming.sjll.my.adapter.ColumnDetailsDataAdapter;
import com.ming.sjll.my.adapter.ColumnImgeAdapter;
import com.ming.sjll.my.adapter.Companydapter;
import com.ming.sjll.my.adapter.HomePageDataAdapter;
import com.ming.sjll.my.bean.ColumnDetailsBean;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.dialog.HomePageDialog;
import com.ming.sjll.my.dialog.UserShareDialog;
import com.ming.sjll.my.presenter.ColumnDetailsPresenter;
import com.ming.sjll.my.presenter.ComplainPresenter;
import com.ming.sjll.my.presenter.HomeagePresenter;
import com.ming.sjll.my.view.ColumnDetailsDataView;
import com.ming.sjll.my.view.HomeageDataView;
import com.ming.sjll.supplier.adapter.RecommendedAdapter;
import com.ming.sjll.supplier.adapter.Talentdapter;

/**
 * 专栏详情
 */

public class ColumnDetailsActivity extends MvpActivity<ColumnDetailsDataView, ColumnDetailsPresenter> implements ColumnDetailsDataView {
    private ActivityRecycleBinding binding;
    private int index;
    private ColumnDetailsDataAdapter homePageDataAdapter;
    private ColumnDetailsHeadItemBinding headBinding;
    private ColumnDetailsBottomItemBinding bottomItemBinding;

    private ColumnDetailsBean columnDetailsBean;
    private ColumnDetailsBean.DataBean.ColumnInfoBean columnInfoBean;
    private ColumnDetailsBean.DataBean.UserInfoBean userInfoBean;

    private double price;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycle);
        //设置标题
        binding.setTitleViewModel(new ToolbarViewModel());
        binding.titleBar.titleBarContentView.setBackgroundColor(getResources().getColor(R.color.transparent));
        binding.titleBar.titleBarIvLeft.setImageResource(R.mipmap.ic_top_with_back);
    }

    @Override
    public void ShowData(ColumnDetailsBean pBean) {
        this.columnDetailsBean = pBean;
        userInfoBean = pBean.getData().getUserInfo();
        columnInfoBean = pBean.getData().getColumnInfo();

        binding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        homePageDataAdapter = new ColumnDetailsDataAdapter(pBean.getData().getCourse());
        binding.recyclerview.setAdapter(homePageDataAdapter);

        headBinding = ColumnDetailsHeadItemBinding.inflate(getLayoutInflater());
        bottomItemBinding = ColumnDetailsBottomItemBinding.inflate(getLayoutInflater());
        homePageDataAdapter.addHeaderView(headBinding.getRoot());
        homePageDataAdapter.addFooterView(bottomItemBinding.getRoot());
        headBinding.ivShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserShareDialog.newInstance().show(ColumnDetailsActivity.this);
            }
        });
        if (columnDetailsBean.getData().getIs_collect() == 1) {
            binding.ivLike.setImageResource(R.mipmap.ic_show_y);
        } else {
            binding.ivLike.setImageResource(R.mipmap.ic_show_n);
        }
        binding.ivLike.setVisibility(View.VISIBLE);
        binding.ivLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.collectColumn();
            }
        });

        //头部信息
        initHead();
        //收藏
        initHeart();
        //专栏信息
        initColumnInfo();
        //底部推荐
        initBootm();
        if (userInfoBean.getIs_approve() == 0) {
            headBinding.tvCertification.setVisibility(View.GONE);
            headBinding.ivCertification.setVisibility(View.GONE);
        } else {
            headBinding.tvCertification.setText("平台认证");
        }


    }

    @Override
    public void collectColumn(BaseBean bean) {
        if (columnDetailsBean.getData().getIs_collect() == 1) {
            binding.ivLike.setImageResource(R.mipmap.ic_show_n);
        } else {
            binding.ivLike.setImageResource(R.mipmap.ic_show_y);
        }

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

    }

    private void initHeart() {
        if (userInfoBean.getIs_collect() == 1) {
            headBinding.ivHeart.setImageResource(R.mipmap.ic_my_heart);
        } else {
            headBinding.ivHeart.setImageResource(R.mipmap.ic_home_page_heart);
        }
        headBinding.tvNumber.setText(userInfoBean.getCollect_num() + "");
    }

    //初始化专栏
    private void initColumnInfo() {
        ImageHelper.displayBackground(headBinding.ivImg, Constant.BASE_API + columnInfoBean.getBg_img(), R.mipmap.ic_launcher);
        headBinding.recyclerview.setLayoutManager(new LinearLayoutManager(this));
        headBinding.recyclerview.setAdapter(new ColumnImgeAdapter(columnInfoBean.getImg()));
        headBinding.tvTitle.setText(columnInfoBean.getTitle());
        headBinding.tvText.setText(columnInfoBean.getContent());
        headBinding.tvAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                headBinding.recyclerview.setVisibility(View.VISIBLE);
                headBinding.tvText.setVisibility(View.VISIBLE);
                headBinding.tvAll.setVisibility(View.GONE);
            }
        });


    }

    //底部推荐
    private void initBootm() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ColumnDetailsActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        bottomItemBinding.recyclerview.setLayoutManager(linearLayoutManager);
        RecommendedAdapter recommendedAdapter = new RecommendedAdapter(columnDetailsBean.getData().getRelated());
        bottomItemBinding.recyclerview.setAdapter(recommendedAdapter);
        recommendedAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putString("cloumn_id", columnDetailsBean.getData().getRelated().get(position).getCloumn_id() + "");
                Tools.jump(ColumnDetailsActivity.this, ColumnDetailsActivity.class, bundle, true);
            }
        });
        bottomItemBinding.tvBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bottomItemBinding.tvBuy.getText().toString().equals("取消购买")) {
                    bottomItemBinding.tvBuy.setText("购买课程");
                    bottomItemBinding.tvBuy.setBackground(getResources().getDrawable(R.drawable.btn_blue_bg));
                    bottomItemBinding.tvBuy.setTextColor(getResources().getColor(R.color.white));
                    homePageDataAdapter.setCheck(false);
                } else if (bottomItemBinding.tvBuy.getText().toString().contains("立即支付")) {
                    ToastShow.s("我要买");
                } else {
                    bottomItemBinding.tvBuy.setText("取消购买");
                    bottomItemBinding.tvBuy.setBackground(getResources().getDrawable(R.drawable.btn_grey_bg));
                    bottomItemBinding.tvBuy.setTextColor(Color.parseColor("#FF8C92A7"));
                    homePageDataAdapter.setCheck(true);
                }

            }
        });
        homePageDataAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.check:
                        CheckBox checkBox = (CheckBox) view;
                        if (checkBox.isChecked()) {
                            price = price + Double.parseDouble(columnDetailsBean.getData().getCourse().get(position).getPrice());

                        } else {
                            price = price - Double.parseDouble(columnDetailsBean.getData().getCourse().get(position).getPrice());
                        }
                        if (price > 0) {
                            bottomItemBinding.tvBuy.setText("立即支付  ￥" + price);
                            bottomItemBinding.tvBuy.setBackground(getResources().getDrawable(R.drawable.btn_blue_bg));
                            bottomItemBinding.tvBuy.setTextColor(getResources().getColor(R.color.white));
                        } else {
                            bottomItemBinding.tvBuy.setText("取消购买");
                            bottomItemBinding.tvBuy.setBackground(getResources().getDrawable(R.drawable.btn_grey_bg));
                            bottomItemBinding.tvBuy.setTextColor(Color.parseColor("#FF8C92A7"));
                        }

                        break;
                    case R.id.iv_img:
                        //播放视频
                        PictureSelector.create(ColumnDetailsActivity.this).externalPictureVideo(Constant.BASE_API + columnDetailsBean.getData().getCourse().get(position).getUrl());
                        break;
                }

            }
        });


    }


}
