package com.ming.sjll;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.AppUtils;
import com.ming.sjll.base.utils.StatusBarUtil;
import com.ming.sjll.message.fragment.MessageFragemt;
import com.ming.sjll.my.fragment.MyFragemt;
import com.ming.sjll.projectmanage.fragment.ProjectFragemt;
import com.ming.sjll.show.fragment.ShowFragemt;

import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;

public class MainActivity extends MvpActivity<MainView, MainPresenter> {


    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;
    @BindView(R.id.rb_4)
    RadioButton rb4;
    @BindView(R.id.rb_5)
    RadioButton rb5;
    List<Fragment> fragmentList;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.LL_6277FF));
        StatusBarUtil.setDarkMode(this);
        initView();

    }

    private void initView() {
        fragmentList = new ArrayList<>();
        fragmentList.add(ProjectFragemt.newInstance());
        fragmentList.add(ShowFragemt.newInstance());
        fragmentList.add(MessageFragemt.newInstance());
        fragmentList.add(MyFragemt.newInstance());
        viewPager.setAdapter(new MyfAdatper(getSupportFragmentManager(), fragmentList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        radioGroup.check(R.id.rb_1);
                        StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.LL_6277FF));
                        break;
                    case 1:
                        radioGroup.check(R.id.rb_2);
                        StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.white));
                        break;
                    case 2:
                        radioGroup.check(R.id.rb_3);
                        StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.white));
                        break;
                    case 3:
                        radioGroup.check(R.id.rb_4);
                        StatusBarUtil.setColor(MainActivity.this, AppUtils.getColor(R.color.white));
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_1:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.rb_2:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.rb_3:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.rb_4:
                        viewPager.setCurrentItem(3);
                        break;

                }

            }
        });

    }


    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
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

    class MyfAdatper extends FragmentPagerAdapter {
        private List<Fragment> fragmentList;

        public MyfAdatper(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragmentList = fragments;
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        return super.onKeyUp(keyCode, event);
    }

}
