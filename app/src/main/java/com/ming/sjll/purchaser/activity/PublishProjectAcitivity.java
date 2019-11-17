package com.ming.sjll.purchaser.activity;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.purchaser.fragment.CityFragemt;
import com.ming.sjll.purchaser.fragment.GeneralSituationFragemt;
import com.ming.sjll.purchaser.fragment.IntroductionFragemt;
import com.ming.sjll.purchaser.fragment.TimerFragemt;
import com.ming.sjll.purchaser.presenter.PublishProjectPresenter;
import com.ming.sjll.purchaser.view.PublishProjectView;
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
import butterknife.ButterKnife;
/**
 * @author luoming
 *created at 2019-11-10 13:32
 * 项目发布
*/
public class PublishProjectAcitivity extends MvpActivity<PublishProjectView, PublishProjectPresenter> implements PublishProjectView {
    @BindView(R.id.title_bar_IvLeft)
    ImageView titleBarIvLeft;
    @BindView(R.id.title_bar_TvTitle)
    TextView titleBarTvTitle;
    @BindView(R.id.viewpager)
    WrapContentHeightViewPager viewpager;
    @BindView(R.id.magic_indicator)
    MagicIndicator magicIndicator;
    @BindView(R.id.scroll_view)
    ScrollView scrollView;

    private List<Fragment> fragmentList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish_project);
        ButterKnife.bind(this);
        titleBarTvTitle.setText("发布项目");
        initEvent();
    }

    @Override
    protected PublishProjectPresenter createPresenter() {
        return new PublishProjectPresenter();
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
        fragmentList.add(GeneralSituationFragemt.newInstance());
        fragmentList.add(CityFragemt.newInstance());
        fragmentList.add(TimerFragemt.newInstance());
        fragmentList.add(IntroductionFragemt.newInstance().setPublishProjectView(this));
        viewpager.setAdapter(new Adaper(getSupportFragmentManager()));
        List<String> mTitleDataList = new ArrayList<>();
        mTitleDataList.add("概述");
        mTitleDataList.add("城市");
        mTitleDataList.add("时间");
        mTitleDataList.add("简介");
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
                        viewpager.setCurrentItem(i);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(PublishProjectAcitivity.this);
                indicator.setMode(2);
                indicator.setRoundRadius(5);
                indicator.setColors(getResources().getColor(R.color.LL_0A3FFF));//线的颜色
                indicator.setLineWidth(Tools.dip2px(PublishProjectAcitivity.this, 12));
                return indicator;
            }
        });
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, viewpager);
    }

    @Override
    public void fullScrollTop(int f) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(f);
            }
        });
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
