package com.ming.sjll.message.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import com.ming.sjll.R;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.message.presenter.MessagePresenter;
import com.ming.sjll.message.view.MessageView;

import io.rong.imkit.fragment.ConversationListFragment;
import io.rong.imlib.model.Conversation;


public class MessageFragment extends MvpFragment<MessageView, MessagePresenter> implements MessageView {

    public static MessageFragment newInstance() {
        return new MessageFragment();
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_message);


        try {
            FragmentManager childFragmentManager = getChildFragmentManager();
            ConversationListFragment fragement = (ConversationListFragment) childFragmentManager.findFragmentById(R.id.conversationlist);
            Uri uri = Uri.parse("rong://" + getActivity().getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversationlist")
                    .appendQueryParameter(Conversation.ConversationType.PRIVATE.getName(), "false")
                    .appendQueryParameter(Conversation.ConversationType.GROUP.getName(), "false")
                    .appendQueryParameter(Conversation.ConversationType.PUBLIC_SERVICE.getName(), "false")
                    .appendQueryParameter(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(), "false")
                    .appendQueryParameter(Conversation.ConversationType.SYSTEM.getName(), "true")
                    .build();
            fragement.setUri(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected MessagePresenter createPresenter() {
        return new MessagePresenter();
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

}
