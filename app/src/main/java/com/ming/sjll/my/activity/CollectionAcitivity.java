package com.ming.sjll.my.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.TypedValue;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityProjectManagementBinding;
import com.ming.sjll.my.fragment.CollectionCourseFragemt;
import com.ming.sjll.my.fragment.CollectionGoodsFragemt;
import com.ming.sjll.my.fragment.CollectionPersonnelFragemt;
import com.ming.sjll.my.fragment.CollectionProjectFragemt;
import com.ming.sjll.purchaser.fragment.ProjectManagementFragemt;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;


/**
 * @author luoming
 * created at 2019-11-10 13:32
 * 收藏
 */
public class CollectionAcitivity extends MvpActivity {

    private List<Fragment> fragmentList;
    private ActivityProjectManagementBinding binding;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_project_management);
        binding.setTitleViewModel(new ToolbarViewModel("收藏"));
        initEvent();
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


    public void initEvent() {
        fragmentList = new ArrayList<>();
        fragmentList.add(CollectionPersonnelFragemt.newInstance());
        fragmentList.add(CollectionGoodsFragemt.newInstance());
        fragmentList.add(CollectionProjectFragemt.newInstance());
        fragmentList.add(CollectionCourseFragemt.newInstance());
        binding.viewpager.setAdapter(new Adaper(getSupportFragmentManager()));
        List<String> mTitleDataList = new ArrayList<>();
        mTitleDataList.add("人员");
        mTitleDataList.add("物品");
        mTitleDataList.add("项目");
        mTitleDataList.add("课程");
        CommonNavigator commonNavigator = new CommonNavigator(this);
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
                        binding.viewpager.setCurrentItem(i);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(CollectionAcitivity.this);
                indicator.setMode(2);
                indicator.setRoundRadius(5);
                indicator.setColors(getResources().getColor(R.color.LL_0A3FFF));//线的颜色
                indicator.setLineWidth(Tools.dip2px(CollectionAcitivity.this, 12));
                return indicator;
            }
        });
        binding.magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(binding.magicIndicator, binding.viewpager);
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
