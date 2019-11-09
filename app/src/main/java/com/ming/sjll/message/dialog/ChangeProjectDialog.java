package com.ming.sjll.message.dialog;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.dialog.BaseDialog;
import com.ming.sjll.databinding.DialogChangeProjectBinding;
import com.ming.sjll.message.fragment.ProjectListFragment;

import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;

import java.util.ArrayList;
import java.util.List;

public class ChangeProjectDialog extends BaseDialog {

    private  DialogChangeProjectBinding binding;
    public static ChangeProjectDialog newInstance() {

        Bundle args = new Bundle();

        ChangeProjectDialog fragment = new ChangeProjectDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getLayoutId() {
        return R.layout.dialog_change_project;
    }

    @Override
    public void initView(ViewDataBinding dataBinding) {
          binding = (DialogChangeProjectBinding) dataBinding;

        binding.tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            //添加项目
            }
        });
        binding.ivClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        initIndicator();
    }

    public void initIndicator() {

        List<String> mTitleDataList = new ArrayList<>();
        mTitleDataList.add("我发起的");
        mTitleDataList.add("我接单的");
        mTitleDataList.add("项目合伙");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(ProjectListFragment.newInstance("0").setItemClick(onClickProjectListener));
        fragments.add(ProjectListFragment.newInstance("1").setItemClick(onClickProjectListener));
        fragments.add(ProjectListFragment.newInstance("2").setItemClick(onClickProjectListener));
        binding.viewPager.setAdapter(new ProjectFragmentAdapter(getChildFragmentManager(), fragments));

        CommonNavigator commonNavigator = new CommonNavigator(getActivity());
        commonNavigator.setAdjustMode(false);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleDataList.size();
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                final ColorTransitionPagerTitleView colorTransitionPagerTitleView = new ColorTransitionPagerTitleView(context);
                colorTransitionPagerTitleView.setNormalColor(Color.parseColor("#000000"));
                colorTransitionPagerTitleView.setSelectedColor(Color.parseColor("#0A3FFF"));
                colorTransitionPagerTitleView.setTextSize(18);
                colorTransitionPagerTitleView.setText(mTitleDataList.get(index));
                colorTransitionPagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        binding.viewPager.setCurrentItem(index);
                    }
                });
                return colorTransitionPagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setColors(Color.parseColor("#0A3FFF"));
                indicator.setMode(LinePagerIndicator.MODE_EXACTLY);
                indicator.setRoundRadius(5);
                indicator.setLineWidth(UIUtil.dip2px(context, 12));
                indicator.setLineHeight(UIUtil.dip2px(context, 3));
                return indicator;
            }
        });
        binding.indicator.setNavigator(commonNavigator);
        binding.viewPager.setOffscreenPageLimit(mTitleDataList.size());
        ViewPagerHelper.bind(binding.indicator, binding.viewPager);
    }
    class ProjectFragmentAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragments = new ArrayList<>();

        public ProjectFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
    @Override
    public boolean isBottom() {
        return false;
    }
    private onClickProjectListener onClickProjectListener;

    public ChangeProjectDialog setOnClickProjectListener(ChangeProjectDialog.onClickProjectListener onClickProjectListener) {
        this.onClickProjectListener = onClickProjectListener;
        return this;
    }

    public interface onClickProjectListener{
        void onClickProject(String type,String projectId,String projectName);
    }
}
