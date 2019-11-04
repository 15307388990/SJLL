package com.ming.sjll.message.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.View;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.databinding.FragemtMessageBinding;
import com.ming.sjll.message.presenter.MessagePresenter;
import com.ming.sjll.message.utils.RongIMUtils;
import com.ming.sjll.message.view.MessageView;

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

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;


public class MessageFragment extends MvpFragment<MessageView, MessagePresenter> implements MessageView {
    private FragemtMessageBinding dataBinding;

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.fragemt_message, null, false);
        setContentView(dataBinding.getRoot());
        String token = "3gL2bzjTLj3xaGja6AHYVdxFchWfWSNTJRNe25CtgPxpClDqMyo3QaS9Lb2ZL3rjTmvxn6B+jM6b2fTACkwjsw==";
        RongIMUtils.INSTANCE.connect(token);

        initIndicator();

    }

    public void initIndicator() {

        List<String> mTitleDataList = new ArrayList<>();
        mTitleDataList.add("消息");
        mTitleDataList.add("通知");
        mTitleDataList.add("系统");

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(createConversationListFragment());
        fragments.add(MessageNotificationListFragment.newInstance());
        fragments.add(MessageSytemNotificationListFragment.newInstance());
        dataBinding.viewPager.setAdapter(new MessageFragmentAdapter(getChildFragmentManager(), fragments));

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
                        dataBinding.viewPager.setCurrentItem(index);
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
        dataBinding.magicIndicator.setNavigator(commonNavigator);
        dataBinding.viewPager.setOffscreenPageLimit(mTitleDataList.size());
        ViewPagerHelper.bind(dataBinding.magicIndicator, dataBinding.viewPager);
    }


    public ConversationListFragment createConversationListFragment(){
        ConversationListFragment mConversationListFragment=MessageConversationListFragment.newInstance();
        try {
            Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversationlist")
                    .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "true")
                    .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "true")
                    .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "true")
                    .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "true")
                    .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")
                    .build();
            mConversationListFragment.setUri(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mConversationListFragment;

    }

    class MessageFragmentAdapter extends FragmentStatePagerAdapter {
        List<Fragment> fragments = new ArrayList<>();

        public MessageFragmentAdapter(FragmentManager fm, List<Fragment> fragments) {
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

}
