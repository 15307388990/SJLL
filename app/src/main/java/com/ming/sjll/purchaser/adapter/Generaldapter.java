package com.ming.sjll.purchaser.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.purchaser.bean.OccupationBean;

import java.util.List;


/**
 * @author luoming
 *created at 2019-10-27 16:08
*/
public class Generaldapter extends BaseQuickAdapter<OccupationBean.DataBean, BaseViewHolder> {

    public Generaldapter(@Nullable List<OccupationBean.DataBean> data) {
        super(R.layout.qccupation_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, OccupationBean.DataBean dataBean) {
        baseViewHolder.setText(R.id.tv_name, dataBean.getTitle());
        // ImageHelper.displayUser((ImageView) baseViewHolder.getView(R.id.iv_icon), Constant.BASE_API + dataBean.getIcon());
        Glide.with(mContext).load(Constant.BASE_API + dataBean.getIcon()).into((ImageView) baseViewHolder.getView(R.id.iv_icon));
        if (dataBean.isSelected()) {
            baseViewHolder.setBackgroundRes(R.id.tv_check, R.drawable.tab_genneral_select);
        } else {
            baseViewHolder.setBackgroundRes(R.id.tv_check, R.drawable.tab_genneral_no);
        }

    }

    @Override
    public void setNewData(@Nullable List<OccupationBean.DataBean> data) {
        this.mData = data;
        notifyDataSetChanged();
    }
}