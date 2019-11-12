package com.ming.sjll.my.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.bean.CurriculumBean;
import com.ming.sjll.purchaser.adapter.ProjectListAdapter;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-27 16:08
 */
public class OrderCurriculumAdapter extends BaseQuickAdapter<CurriculumBean.DataBeanX.DataBean, BaseViewHolder> {

    public OrderCurriculumAdapter(@Nullable List<CurriculumBean.DataBeanX.DataBean> data) {
        super(R.layout.order_curriculum_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CurriculumBean.DataBeanX.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getColumnTitle());
        baseViewHolder.setText(R.id.tv_number, dataBean.getNum());
        RecyclerView recyclerView = baseViewHolder.getView(R.id.recyclerview);
        TextView tvShou = baseViewHolder.getView(R.id.tv_shou);

        tvShou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerView.getVisibility() == View.VISIBLE) {
                    tvShou.setText("展开");
                    recyclerView.setVisibility(View.GONE);
                } else {
                    tvShou.setText("收起");
                    recyclerView.setVisibility(View.VISIBLE);
                }
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(new CurriculumListAdapter(dataBean.getList()));

    }

}