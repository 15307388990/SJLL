package com.ming.sjll.message.fragment;

import android.content.Context;

import io.rong.imkit.fragment.ConversationFragment;
import io.rong.imkit.widget.adapter.MessageListAdapter;

public class MessageConversationFragment extends ConversationFragment {

    public MessageListAdapter onResolveAdapter(Context context) {
        return new MessageConversationAdapter(context);
    }

    public class MessageConversationAdapter extends MessageListAdapter{
        public MessageConversationAdapter(Context context) {
            super(context);
        }
    }
}
