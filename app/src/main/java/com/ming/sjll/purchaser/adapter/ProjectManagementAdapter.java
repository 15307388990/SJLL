package com.ming.sjll.purchaser.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-27 16:08
 */
public class ProjectManagementAdapter extends BaseQuickAdapter<ProjectManagementBean.DataBeanX.DataBean, BaseViewHolder> {

    public ProjectManagementAdapter(@Nullable List<ProjectManagementBean.DataBeanX.DataBean> data) {
        super(R.layout.project_management_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ProjectManagementBean.DataBeanX.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_timer, Tools.getDateformat3(dataBean.getDateTime(), "yyyy年MM月"));
        RecyclerView recyclerView = baseViewHolder.getView(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(new ProjectListAdapter(dataBean.getList()));

    }

}