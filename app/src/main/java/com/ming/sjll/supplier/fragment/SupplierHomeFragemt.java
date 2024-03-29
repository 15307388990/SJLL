package com.ming.sjll.supplier.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.purchaser.view.CustomRoundAngleImageView;
import com.ming.sjll.supplier.adapter.SupplierHomeAdapter;
import com.ming.sjll.supplier.bean.HomeAdsBean;
import com.ming.sjll.supplier.bean.HomeColumBean;
import com.ming.sjll.supplier.presenter.SupplierHomePresenter;
import com.ming.sjll.supplier.view.SupplierHomeView;
import com.ming.sjll.view.WrapContentHeightViewPager;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-14 10:32
 * 供应商首页
 */
public class SupplierHomeFragemt extends MvpFragment<SupplierHomeView, SupplierHomePresenter> implements SupplierHomeView {


    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.viewpager)
    WrapContentHeightViewPager viewpager;
    List<Fragment> fragmentList;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.iv_img)
    CustomRoundAngleImageView ivImg;

    public static SupplierHomeFragemt newInstance() {
        return new SupplierHomeFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_supplier_home);
        initEvent();

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.showDate();
    }

    public void initEvent() {
        fragmentList = new ArrayList<>();
        fragmentList.add(ComprehensiveFragemt.newInstance());
        fragmentList.add(NoticeFragemt.newInstance());
        viewpager.setAdapter(new Adaper(getChildFragmentManager()));
        List<String> mTitleDataList = new ArrayList<>();
        mTitleDataList.add("综合");
        mTitleDataList.add("通告");
        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, int i) {
                ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(getResources().getColor(R.color.LL_000000));
                colorTransitionPagerTitleView.setSelectedColor(getResources().getColor(R.color.LL_0A3FFF));
                colorTransitionPagerTitleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                colorTransitionPagerTitleView.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                colorTransitionPagerTitleView.setText(mTitleDataList.get(i));
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewpager.setCurrentItem(i);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(getActivity());
                indicator.setMode(2);
                indicator.setRoundRadius(5);
                indicator.setColors(getResources().getColor(R.color.LL_0A3FFF));//线的颜色
                indicator.setLineWidth(Tools.dip2px(getActivity(), 12));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewpager);
    }

    @Override
    protected SupplierHomePresenter createPresenter() {
        return new SupplierHomePresenter();
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
    public void ShowDate(HomeColumBean homeColumBean) {
        recyclerview.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        recyclerview.setAdapter(new SupplierHomeAdapter(homeColumBean.getData()));
    }

    @Override
    public void ShowImg(HomeAdsBean bean) {
        if (bean.getData().getBanner_img() != null) {
            ivImg.setVisibility(View.VISIBLE);
            ImageHelper.displayBackground((ivImg), Constant.BASE_API + bean.getData().getBanner_img(), R.drawable.ic_launcher_background);

        } else {
            ivImg.setVisibility(View.GONE);
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
