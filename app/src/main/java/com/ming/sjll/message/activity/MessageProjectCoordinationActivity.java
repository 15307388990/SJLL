package com.ming.sjll.message.activity;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.ImageLoaderUtil;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityManagerInfoBinding;
import com.ming.sjll.message.presenter.MessageProjectCoordinationPresenter;
import com.ming.sjll.message.view.MessageProjectCoordinationView;
import com.ming.sjll.message.viewmodel.MessageProjectCoordinationViewModel;

import java.util.List;


public class MessageProjectCoordinationActivity extends MvpActivity<MessageProjectCoordinationView, MessageProjectCoordinationPresenter> implements MessageProjectCoordinationView {

    private ActivityManagerInfoBinding viewDataBinding;
    private MemberInfoApter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_manager_info);
        viewDataBinding.setTitleViewModel(new ToolbarViewModel("项目统筹"));
        viewDataBinding.rcMember.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onShowData(List<MessageProjectCoordinationViewModel.DataBeanX.DataEntity> data) {
        adapter = new MemberInfoApter(data);
        viewDataBinding.rcMember.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                MessageProjectCoordinationViewModel.DataBeanX.DataEntity item = (MessageProjectCoordinationViewModel.DataBeanX.DataEntity) adapter.getItem(position);
                if (view.getId() == R.id.tv_span) {
                    //修改状态，刷新数据
                    item.toggeleExpand();
                    adapter.notifyDataSetChanged();
                } else if (view.getId() == R.id.tv_refuse) {//拒绝
                    //刷新数据
                    mPresenter.applyPass(item.getApply_id(), false);
                } else if (view.getId() == R.id.tv_receive) {//接收
                    mPresenter.applyPass(item.getApply_id(), true);
                }
            }
        });

    }



    public class MemberInfoApter extends BaseQuickAdapter<MessageProjectCoordinationViewModel.DataBeanX.DataEntity, BaseViewHolder> {

        public MemberInfoApter(@Nullable List<MessageProjectCoordinationViewModel.DataBeanX.DataEntity> data) {
            super(R.layout.message_project_coordination_item, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, MessageProjectCoordinationViewModel.DataBeanX.DataEntity dataBean) {

            if (dataBean.getOccupation() != null && !dataBean.getOccupation().isEmpty()) {
                String s = dataBean.getOccupation().get(0);
                baseViewHolder.setText(R.id.tv_position, s);
            }

            baseViewHolder.setText(R.id.tv_operation, dataBean.getDemand());
            baseViewHolder.setText(R.id.tv_name, dataBean.getName());

            baseViewHolder.setText(R.id.brand, dataBean.getBrand());
            baseViewHolder.setText(R.id.budget, "¥"+dataBean.getBudget());
            baseViewHolder.setText(R.id.time, dataBean.getStart_time() + "-" + dataBean.getEnd_time());


            ImageLoaderUtil.display(baseViewHolder.getView(R.id.header),dataBean.getDefault_avatar());


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

                baseViewHolder.setText(R.id.tv_operation, dataBean.getDemand());
                baseViewHolder.setTextColor(R.id.tv_operation, Color.parseColor("#000000"));
            } else {

                String prefix = "申请加入";
                SpannableString ss = new SpannableString(prefix + dataBean.getDemand());
                ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#0A3FFF"));
                ss.setSpan(colorSpan, 0, prefix.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                baseViewHolder.setText(R.id.tv_operation, ss);

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