package com.ming.sjll.message.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.ImageLoaderUtil;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityManagerInfoBinding;
import com.ming.sjll.message.presenter.ManagerMemberInfoPresenter;
import com.ming.sjll.message.view.ManagerMemberView;
import com.ming.sjll.message.viewmodel.ManagerMemberInfoViewModel;

import java.util.ArrayList;
import java.util.List;


public class MessageCompanyApplyActivity extends MvpActivity<ManagerMemberView, ManagerMemberInfoPresenter> implements ManagerMemberView {

    private ActivityManagerInfoBinding viewDataBinding;
    private ArrayList<ManagerMemberInfoViewModel> data;
    private MemberInfoApter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.message_chat_notify_fragment);
        viewDataBinding.setTitleViewModel(new ToolbarViewModel("申请加入"));
        viewDataBinding.rcMember.setLayoutManager(new LinearLayoutManager(this));

        data = new ArrayList<>();
        ManagerMemberInfoViewModel memberInfoViewModel = new ManagerMemberInfoViewModel();

        data.add(memberInfoViewModel);
        data.add(memberInfoViewModel);
        data.add(memberInfoViewModel);
        adapter = new MemberInfoApter(data);
        viewDataBinding.rcMember.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.tv_refuse) {//拒绝
                    adapter.remove(position);
                    adapter.notifyDataSetChanged();
                } else if (view.getId() == R.id.tv_receive) {//接收
                    adapter.remove(position);
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }

    public class MemberInfoApter extends BaseQuickAdapter<ManagerMemberInfoViewModel, BaseViewHolder> {

        public MemberInfoApter(@Nullable List<ManagerMemberInfoViewModel> data) {
            super(R.layout.message_apply_join_in_item, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, ManagerMemberInfoViewModel dataBean) {
            baseViewHolder.setText(R.id.tv_name, " 申请加入Lucas Wakamatsu 新品拍摄");
            baseViewHolder.setText(R.id.tv_position, "  ");
            ImageLoaderUtil.display(baseViewHolder.getView(R.id.header), "");
            baseViewHolder.addOnClickListener(R.id.tv_refuse);
            baseViewHolder.addOnClickListener(R.id.tv_receive);
        }

    }


}