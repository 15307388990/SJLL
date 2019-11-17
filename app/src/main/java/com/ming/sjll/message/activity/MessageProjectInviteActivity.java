package com.ming.sjll.message.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityManagerInfoBinding;
import com.ming.sjll.message.presenter.MessageProjectInvitePresenter;
import com.ming.sjll.message.view.MessageProjectInviteView;
import com.ming.sjll.message.viewmodel.ProjectInviteBean;

import java.util.ArrayList;
import java.util.List;


public class MessageProjectInviteActivity extends MvpActivity<MessageProjectInviteView, MessageProjectInvitePresenter> implements MessageProjectInviteView {

    private ActivityManagerInfoBinding viewDataBinding;
    private MemberInfoApter adapter;
    private List<ProjectInviteBean.DataBeanX.DataBean> dataBeans = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_manager_info);
        viewDataBinding.setTitleViewModel(new ToolbarViewModel("参与确认"));
        viewDataBinding.rcMember.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onShowData(ProjectInviteBean.DataBeanX data) {
        List<ProjectInviteBean.DataBeanX.DataBean> dataBeans = data.getData();
        adapter = new MemberInfoApter(dataBeans);
        viewDataBinding.rcMember.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ProjectInviteBean.DataBeanX.DataBean dataBean = dataBeans.get(position);
                if (view.getId() == R.id.tv_span) {
                    //修改状态，刷新数据
                    dataBean.toggeleExpand();
                    adapter.notifyDataSetChanged();
                } else if (view.getId() == R.id.tv_refuse) {//拒绝
                    adapter.notifyDataSetChanged();
                } else if (view.getId() == R.id.tv_receive) {//接收
                    adapter.notifyDataSetChanged();
                }
            }
        });

    }

    public class MemberInfoApter extends BaseQuickAdapter<ProjectInviteBean.DataBeanX.DataBean, BaseViewHolder> {

        public MemberInfoApter(@Nullable List<ProjectInviteBean.DataBeanX.DataBean> data) {
            super(R.layout.message_confirm_join_item, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, ProjectInviteBean.DataBeanX.DataBean dataBean) {

            baseViewHolder.setText(R.id.tv_operation, dataBean.getDemand());
            baseViewHolder.setText(R.id.tv_position, dataBean.getOccupation());
            baseViewHolder.setText(R.id.tv_invite, dataBean.getInviteUser());

            baseViewHolder.setText(R.id.brand, dataBean.getBrand());
            baseViewHolder.setText(R.id.budget,"¥"+ dataBean.getBudget());
            baseViewHolder.setText(R.id.time, dataBean.getStart_time()+"-"+dataBean.getEnd_time());


            boolean isDropDown = dataBean.isExpand();//是否是展开状态
            if (isDropDown) {
                baseViewHolder.setText(R.id.tv_span, "收起需求");
                baseViewHolder.setGone(R.id.ll_content, true);
                baseViewHolder.setImageResource(R.id.iv_drop,R.mipmap.coodinate_up);

            } else {
                baseViewHolder.setText(R.id.tv_span, "展开需求");
                baseViewHolder.setImageResource(R.id.iv_drop,R.mipmap.coodinate_down);
                baseViewHolder.setGone(R.id.ll_content, false);
            }

            //            状态 0- 申请中 1-已同意 2-已拒绝 3-已过期
            boolean isOutDate = TextUtils.equals(dataBean.getStatus(), "1") || TextUtils.equals(dataBean.getStatus(), "2") || TextUtils.equals(dataBean.getStatus(), "3");

            if (isOutDate) {
                baseViewHolder.setVisible(R.id.tv_refuse, false);
                baseViewHolder.setVisible(R.id.tv_receive, false);
                baseViewHolder.setVisible(R.id.tv_out_date, true);
                if (TextUtils.equals(dataBean.getStatus(), "1")) {
                    baseViewHolder.setText(R.id.tv_out_date, "已确认");
                } else if (TextUtils.equals(dataBean.getStatus(), "2")) {
                    baseViewHolder.setText(R.id.tv_out_date, "已拒绝");
                } else if (TextUtils.equals(dataBean.getStatus(), "3")) {
                    baseViewHolder.setText(R.id.tv_out_date, "已过期");
                }

                baseViewHolder.setTextColor(R.id.tv_operation, Color.parseColor("#000000"));
            } else {
                baseViewHolder.setTextColor(R.id.tv_operation, Color.parseColor("#0A3FFF"));

                baseViewHolder.setVisible(R.id.tv_refuse, true);
                baseViewHolder.setVisible(R.id.tv_receive, true);
                baseViewHolder.setVisible(R.id.tv_out_date, false);
            }

            baseViewHolder.addOnClickListener(R.id.tv_span);
            baseViewHolder.addOnClickListener(R.id.tv_refuse);
            baseViewHolder.addOnClickListener(R.id.tv_receive);
        }

    }


}