package com.ming.sjll.message.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.base.fragment.BaseV4Fragment;
import com.ming.sjll.base.utils.ImageLoaderUtil;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.databinding.MessageChatNotifyFragmentBinding;
import com.ming.sjll.message.activity.MessageCompanyApplyActivity;
import com.ming.sjll.message.activity.MessageProjectConfirmJoinActivity;
import com.ming.sjll.message.activity.MessageProjectCoordinationActivity;
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
        viewModel.setCount("0");
        viewModel.setUrl(R.mipmap.message_notify_1);


        MessageNotifyViewModel viewModel1 = new MessageNotifyViewModel();
        viewModel1.setContent("项目参与确认");
        viewModel1.setCount("1");
        viewModel1.setUrl(R.mipmap.message_notify_2);


        MessageNotifyViewModel viewModel2 = new MessageNotifyViewModel();
        viewModel2.setContent("公司申请");
        viewModel2.setCount("2");
        viewModel2.setUrl(R.mipmap.message_notify_3);


        data.add(viewModel);
        data.add(viewModel1);
        data.add(viewModel2);
        MessageNotifyAdapter adapter = new MessageNotifyAdapter(data);
        dataBinding.rcNotification.setAdapter(adapter);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                 if (position == 0){
                     Tools.jump(getActivity(), MessageProjectCoordinationActivity.class,false);
                 }else if (position == 1){
                     Tools.jump(getActivity(), MessageProjectConfirmJoinActivity.class,false);
                 }else if (position == 2){
                     Tools.jump(getActivity(), MessageCompanyApplyActivity.class,false);
                 }
            }
        });
    }

    public class MessageNotifyAdapter extends BaseQuickAdapter<MessageNotifyViewModel, BaseViewHolder> {

        public MessageNotifyAdapter(@Nullable List<MessageNotifyViewModel> data) {
            super(R.layout.message_chat_notify_item, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, MessageNotifyViewModel dataBean) {
            baseViewHolder.setText(R.id.name, dataBean.getContent());
            ImageLoaderUtil.display(baseViewHolder.getView(R.id.header), dataBean.getUrl());
            baseViewHolder.setText(R.id.un_read, dataBean.getCount());
            baseViewHolder.setGone(R.id.un_read,TextUtils.isEmpty(dataBean.getCount()) || TextUtils.equals("0",dataBean.getCount()));

        }

    }

}

