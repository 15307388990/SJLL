package com.ming.sjll.purchaser.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.purchaser.presenter.ProjectPurchaserPresenter;
import com.ming.sjll.purchaser.view.PurchaserView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-10-12 14:35
 * 项目管理采购商页面
 */
public class ProjectPurchaserFragemt extends MvpFragment<PurchaserView, ProjectPurchaserPresenter> implements PurchaserView {


    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;

    List<Fragment> fragmentList;

    public static ProjectPurchaserFragemt newInstance() {
        return new ProjectPurchaserFragemt();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_project_purchaser);
        initView();
    }

    private void initView() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                initSize();
                switch (checkedId) {
                    case R.id.rb_1:
                        viewpager.setCurrentItem(0);
                        rb1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                        break;
                    case R.id.rb_2:
                        viewpager.setCurrentItem(1);
                        rb2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                        break;
                    case R.id.rb_3:
                        viewpager.setCurrentItem(2);
                        rb3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
                        break;
                }
            }
        });
        fragmentList = new ArrayList<>();
        fragmentList.add(PurchaserHomeFragemt.newInstance());
        fragmentList.add(PurchaserVisualFragemt.newInstance());
        fragmentList.add(PuchaserTalentFragemt.newInstance());
        viewpager.setAdapter(new Adaper(getChildFragmentManager()));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        radioGroup.check(R.id.rb_1);
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_2);
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_3);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }


    private void initSize() {
        rb1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        rb2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        rb3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
    }

    @Override
    protected ProjectPurchaserPresenter createPresenter() {
        return new ProjectPurchaserPresenter();
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
