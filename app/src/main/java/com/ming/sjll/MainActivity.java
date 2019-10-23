package com.ming.sjll;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.message.fragment.MessageFragemt;
import com.ming.sjll.my.fragment.MyFragemt;
import com.ming.sjll.purchaser.fragment.ProjectFragemt;
import com.ming.sjll.show.fragment.ShowFragemt;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import butterknife.BindView;

public class MainActivity extends MvpActivity<MainView, MainPresenter> {


    @BindView(R.id.rb_1)
    RadioButton rb1;
    @BindView(R.id.rb_2)
    RadioButton rb2;
    @BindView(R.id.rb_3)
    RadioButton rb3;
    @BindView(R.id.rb_4)
    RadioButton rb4;
    @BindView(R.id.radio_group)
    RadioGroup radioGroup;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;

    private Fragment[] mFragments;
    private ProjectFragemt projectFragemt;
    private ShowFragemt showFragemt;
    private MessageFragemt messageFragemt;
    private MyFragemt myFragemt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        projectFragemt = ProjectFragemt.newInstance();
        showFragemt = ShowFragemt.newInstance();
        messageFragemt = MessageFragemt.newInstance();
        myFragemt = MyFragemt.newInstance();
        mFragments = new Fragment[]{projectFragemt, showFragemt, messageFragemt, myFragemt};
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {

                    case R.id.rb_1:
                        showFragment(projectFragemt);
                        break;
                    case R.id.rb_2:
                        showFragment(showFragemt);
                        break;
                    case R.id.rb_3:
                        showFragment(messageFragemt);
                        break;
                    case R.id.rb_4:
                        showFragment(myFragemt);
                        break;

                }

            }
        });
        showFragment(projectFragemt);
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

    /**
     * 显示fragment
     */
    private void showFragment(MvpFragment fragment) {
        if (!fragment.isAdded()) {
            getSupportFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.framelayout, fragment, fragment.getClass().getName()).commitAllowingStateLoss();
            for (Fragment f : mFragments) {
                FragmentTransaction transaction2 = getSupportFragmentManager().beginTransaction();
                if (f == fragment) {
                    if (fragment.isHidden()) {
                        transaction2.show(f).commitAllowingStateLoss();
                    }
                } else {
                    if (f.isAdded()) {
                        transaction2.hide(f).commitAllowingStateLoss();
                    }
                }
            }
        } else {
            for (Fragment f : mFragments) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (f == fragment) {
                    if (fragment.isHidden()) {
                        transaction.show(f).commitAllowingStateLoss();
                    }
                } else {
                    if (f.isAdded()) {
                        transaction.hide(f).commitAllowingStateLoss();
                    }
                }
            }

        }
    }


}
