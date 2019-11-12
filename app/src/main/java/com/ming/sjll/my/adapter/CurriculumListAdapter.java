package com.ming.sjll.my.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.message.dialog.ChangeProjectDialog;
import com.ming.sjll.my.bean.CurriculumBean;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 课程列表
 */
public class CurriculumListAdapter extends BaseQuickAdapter<CurriculumBean.DataBeanX.DataBean.ListBean, BaseViewHolder> {

    public CurriculumListAdapter(@Nullable List<CurriculumBean.DataBeanX.DataBean.ListBean> data) {
        super(R.layout.curriculum_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CurriculumBean.DataBeanX.DataBean.ListBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getCover_img(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_price, "￥" + dataBean.getPrice());
        baseViewHolder.addOnClickListener(R.id.iv_play);


    }

}