package com.ming.sjll.message.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.BaseV4Fragment;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.databinding.MessageChatNotifyFragmentBinding;
import com.ming.sjll.message.viewmodel.MessageNotifyViewModel;

import java.util.ArrayList;
import java.util.List;

public class MessageNotificationListFragment extends BaseV4Fragment {
    private MessageChatNotifyFragmentBinding dataBinding;

    public static MessageNotificationListFragment newInstance() {

        Bundle args = new Bundle();

        MessageNotificationListFragment fragment = new MessageNotificationListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.message_chat_notify_fragment, null, false);
        setContentView(dataBinding.getRoot());

        dataBinding.rcNotification.setLayoutManager(new LinearLayoutManager(getContext()));
        ArrayList<MessageNotifyViewModel> data = new ArrayList<>();
        MessageNotifyViewModel viewModel = new MessageNotifyViewModel();
        viewModel.setContent("项目统筹");
        viewModel.setCount("5");
        data.add(viewModel);
        dataBinding.rcNotification.setAdapter(new MessageNotifydapter(data));
    }

    public class MessageNotifydapter extends BaseQuickAdapter<MessageNotifyViewModel, BaseViewHolder> {

        public MessageNotifydapter(@Nullable List<MessageNotifyViewModel> data) {
            super(R.layout.message_chat_notify_item, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, MessageNotifyViewModel dataBean) {
            baseViewHolder.setText(R.id.name, dataBean.getContent());
            ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.header), Constant.BASE_API + dataBean.getUrl(),R.drawable.ic_launcher_background);
            baseViewHolder.setText(R.id.un_read, dataBean.getCount());
            baseViewHolder.setGone(R.id.un_read,TextUtils.isEmpty(dataBean.getCount()) || TextUtils.equals("0",dataBean.getCount()));

        }

    }

}

