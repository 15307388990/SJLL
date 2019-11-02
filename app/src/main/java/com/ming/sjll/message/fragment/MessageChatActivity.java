package com.ming.sjll.message.fragment;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.message.presenter.MessagePresenter;
import com.ming.sjll.message.view.MessageView;

import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Conversation;


public class MessageChatActivity extends MvpActivity<MessageView, MessagePresenter> implements MessageView {

    public static MessageChatActivity newInstance() {
        return new MessageChatActivity();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            String mtargetId = "";
            Conversation.ConversationType mConversationType = Conversation.ConversationType.APP_PUBLIC_SERVICE;
            FragmentManager fragmentManage = getSupportFragmentManager();
            ConversationFragment fragement = (ConversationFragment) fragmentManage.findFragmentById(R.id.conversation);
            Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversation").appendPath(mConversationType.getName().toLowerCase())
                    .appendQueryParameter("targetId", mtargetId).build();

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


}
