package com.ming.sjll.message.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityMessageChatBinding;
import com.ming.sjll.message.presenter.MessagePresenter;
import com.ming.sjll.message.view.MessageView;

import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imlib.model.Conversation;


public class MessageChatActivity extends MvpActivity<MessageView, MessagePresenter> implements MessageView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMessageChatBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_message_chat);
        try {
            Intent intent = getIntent();
            Uri dataUri = intent.getData();
            if (dataUri != null) {
                String mtargetId = dataUri.getQueryParameter("targetId");
                String title = dataUri.getQueryParameter("title");
                //设置标题
                binding.setTitleViewModel(new ToolbarViewModel(title));

                ConversationFragment conversationListFragment = createConversationListFragment("");
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, conversationListFragment)
                        .commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ConversationFragment createConversationListFragment(String mtargetId) {
        ConversationFragment fragement = new ConversationFragment();
        try {
            Conversation.ConversationType mConversationType = Conversation.ConversationType.APP_PUBLIC_SERVICE;
            Uri uri = Uri.parse("rong://" + getApplicationInfo().packageName).buildUpon()
                    .appendPath("conversation").appendPath(mConversationType.getName().toLowerCase())
                    .appendQueryParameter("targetId", mtargetId).build();
            fragement.setUri(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragement;

    }

}
