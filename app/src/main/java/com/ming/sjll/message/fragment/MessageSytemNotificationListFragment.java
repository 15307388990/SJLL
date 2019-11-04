package com.ming.sjll.message.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.base.fragment.BaseV4Fragment;
import com.ming.sjll.databinding.MessageChatNotifyFragmentBinding;
import com.ming.sjll.message.viewmodel.MessageSystemNotifyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MessageSytemNotificationListFragment extends BaseV4Fragment {
    private MessageChatNotifyFragmentBinding dataBinding;

    public static MessageSytemNotificationListFragment newInstance() {

        Bundle args = new Bundle();

        MessageSytemNotificationListFragment fragment = new MessageSytemNotificationListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.message_chat_notify_fragment, null, false);
        setContentView(dataBinding.getRoot());

        dataBinding.rcNotification.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<MessageSystemNotifyViewModel> data = new ArrayList<>();
        MessageSystemNotifyViewModel viewModel = new MessageSystemNotifyViewModel();
        viewModel.setContent("Lucas Wakamatsu 新品摄影");
        viewModel.setTime("2019/10/15 12:46:50");
        data.add(viewModel);
        data.add(viewModel);
        data.add(viewModel);
        dataBinding.rcNotification.setAdapter(new MessageNotifydapter(data));
    }

    public class MessageNotifydapter extends BaseQuickAdapter<MessageSystemNotifyViewModel, BaseViewHolder> {

        public MessageNotifydapter(@Nullable List<MessageSystemNotifyViewModel> data) {
            super(R.layout.message_system_item, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, MessageSystemNotifyViewModel dataBean) {
            baseViewHolder.setText(R.id.content, dataBean.getContent());
            baseViewHolder.setText(R.id.time, dataBean.getTime());

        }

    }

}

