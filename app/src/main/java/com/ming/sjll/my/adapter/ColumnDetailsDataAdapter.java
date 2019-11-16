package com.ming.sjll.my.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jet.flowtaglayout.FlowTagLayout;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.bean.ColumnDetailsBean;
import com.ming.sjll.my.bean.HomePageBean;

import java.util.ArrayList;
import java.util.List;


/**
 * @author luoming
 * created at 2019-10-27 16:08
 */
public class ColumnDetailsDataAdapter extends BaseQuickAdapter<ColumnDetailsBean.DataBean.CourseBean, BaseViewHolder> {
    private boolean isCheck = false;

    public ColumnDetailsDataAdapter(@Nullable List<ColumnDetailsBean.DataBean.CourseBean> data) {
        super(R.layout.column_details_data_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ColumnDetailsBean.DataBean.CourseBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());
        ImageHelper.displayBackground(baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getCover_img(), R.mipmap.ic_launcher);
        if (isCheck) {
            baseViewHolder.setGone(R.id.check, true);
        } else {
            baseViewHolder.setGone(R.id.check, false);
        }
        if (dataBean.getIs_pay() == 1) {
            baseViewHolder.setGone(R.id.rl_paly, true);
            baseViewHolder.setGone(R.id.rl_suo, false);
            baseViewHolder.setGone(R.id.tv_buy, true);
            if (isCheck) {
                baseViewHolder.setVisible(R.id.check, false);
            }

        } else {
            baseViewHolder.setGone(R.id.rl_paly, false);
            baseViewHolder.setGone(R.id.rl_suo, true);
            baseViewHolder.setGone(R.id.tv_buy, false);
        }
        baseViewHolder.setText(R.id.tv_timer, dataBean.getDuration());
        baseViewHolder.setText(R.id.tv_price, dataBean.getPrice());
        baseViewHolder.addOnClickListener(R.id.check);


    }

    public void setCheck(boolean check) {
        isCheck = check;
        notifyDataSetChanged();
    }
}