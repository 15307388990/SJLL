package com.ming.sjll.message.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.utils.ImageLoaderUtil;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityManagerInfoBinding;
import com.ming.sjll.message.presenter.MessageCompanyApplyPresenter;
import com.ming.sjll.message.view.MessageCompanyApplyView;
import com.ming.sjll.message.viewmodel.CompanyApplyBean;

import java.util.ArrayList;
import java.util.List;


public class MessageCompanyApplyActivity extends MvpActivity<MessageCompanyApplyView, MessageCompanyApplyPresenter> implements MessageCompanyApplyView {

    private ActivityManagerInfoBinding viewDataBinding;
    private ArrayList<CompanyApplyBean.DataBeanX.DataBean> data;
    private MemberInfoApter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_manager_info);
        viewDataBinding.setTitleViewModel(new ToolbarViewModel("申请加入"));
        viewDataBinding.rcMember.setLayoutManager(new LinearLayoutManager(this));

        data = new ArrayList<>();


    }

    @Override
    public void onShowData(CompanyApplyBean.DataBeanX data) {
        List<CompanyApplyBean.DataBeanX.DataBean> dataBeans = data.getData();
        adapter = new MemberInfoApter(dataBeans);
        viewDataBinding.rcMember.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CompanyApplyBean.DataBeanX.DataBean dataBean = dataBeans.get(position);
                if (view.getId() == R.id.tv_refuse) {//忽略
                    mPresenter.companyPass(dataBean.getApply_id(), false);
                } else if (view.getId() == R.id.tv_receive) {//接收
                    mPresenter.companyPass(dataBean.getApply_id(), true);
                }
            }
        });
    }

    public class MemberInfoApter extends BaseQuickAdapter<CompanyApplyBean.DataBeanX.DataBean, BaseViewHolder> {

        public MemberInfoApter(@Nullable List<CompanyApplyBean.DataBeanX.DataBean> data) {
            super(R.layout.message_apply_join_in_item, data);
        }

        @Override
        protected void convert(BaseViewHolder baseViewHolder, CompanyApplyBean.DataBeanX.DataBean dataBean) {
            baseViewHolder.setText(R.id.tv_name, dataBean.getName());

            StringBuilder builder = new StringBuilder();
            if (dataBean.getOccupation() != null) {
                for (int i = 0; i < dataBean.getOccupation().size(); i++) {
                    String s = dataBean.getOccupation().get(i);
                    builder.append(s);
                    if (i != dataBean.getOccupation().size() - 1) {
                        builder.append("·");
                    }
                }
            }
            baseViewHolder.setText(R.id.tv_position, builder.toString());
            ImageLoaderUtil.display(baseViewHolder.getView(R.id.header), dataBean.getDefault_avatar());



//            状态 0- 申请中 1-已同意 2-已忽略
            boolean isOutDate = TextUtils.equals(dataBean.getStatus(), "1") || TextUtils.equals(dataBean.getStatus(), "2") || TextUtils.equals(dataBean.getStatus(), "0");

            if (isOutDate) {
                baseViewHolder.setVisible(R.id.tv_refuse, false);
                baseViewHolder.setVisible(R.id.tv_receive, false);
                baseViewHolder.setVisible(R.id.tv_out_date, true);
                if (TextUtils.equals(dataBean.getStatus(), "1")) {
                    baseViewHolder.setText(R.id.tv_out_date, "已同意");
                } else if (TextUtils.equals(dataBean.getStatus(), "2")) {
                    baseViewHolder.setText(R.id.tv_out_date, "已忽略");
                } else if (TextUtils.equals(dataBean.getStatus(), "0")) {
                    baseViewHolder.setText(R.id.tv_out_date, "申请中");
                }

            } else {

                baseViewHolder.setVisible(R.id.tv_refuse, true);
                baseViewHolder.setVisible(R.id.tv_receive, true);
                baseViewHolder.setVisible(R.id.tv_out_date, false);
            }



            baseViewHolder.addOnClickListener(R.id.tv_refuse);
            baseViewHolder.addOnClickListener(R.id.tv_receive);
        }

    }


}