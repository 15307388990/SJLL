package com.ming.sjll;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.message.activity.MessageChatActivity;
import com.ming.sjll.message.fragment.MessageFragment;
import com.ming.sjll.my.fragment.MyFragemt;
import com.ming.sjll.purchaser.fragment.ProjectFragemt;
import com.ming.sjll.show.fragment.ShowFragemt;

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
    private MessageFragment messageFragemt;
    private MyFragemt myFragemt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        openPdfChatActivity(getIntent());

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        openPdfChatActivity(intent);
    }

    /**
     * 微信打开APP，发送pdf文件信息
     */
    private void openPdfChatActivity(Intent intent) {
        try {
            if (TextUtils.equals(intent.getAction(), Intent.ACTION_VIEW) && intent.getType().equals("application/pdf")) {
                //记录上次的用户id
                Intent newIntent = new Intent(this, MessageChatActivity.class);
                newIntent.putExtra("fromWechat",true);
                newIntent.setData(intent.getData());
                startActivity(newIntent);
            }
        } catch (Exception e) {
        }
    }

    private void initView() {
        projectFragemt = ProjectFragemt.newInstance();
        showFragemt = ShowFragemt.newInstance();
        messageFragemt = MessageFragment.newInstance();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        myFragemt.onActivityResult(requestCode, resultCode, data);
    }
}
