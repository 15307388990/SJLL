package com.ming.sjll.show.adapter;

import android.widget.Adapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.show.bean.ShowWorkBean;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * Created by HanHailong on 15/10/19.
 */
public class ShowAdapter extends BaseQuickAdapter<ShowWorkBean.DataBean, BaseViewHolder> {

    public ShowAdapter(@Nullable List<ShowWorkBean.DataBean> data) {
        super(R.layout.show_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ShowWorkBean.DataBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img),
                Constant.BASE_API + dataBean.getCover_img(), R.drawable.ic_launcher_background);
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_head),
                Constant.BASE_API + dataBean.getDefault_avatar(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_name, dataBean.getName());
        StringBuffer occupation = new StringBuffer();
        for (String string : dataBean.getOccupation()) {
            occupation.append(string + "  ");
        }
        baseViewHolder.setText(R.id.tv_occupation, occupation);
        if (dataBean.getIs_like() == 0) {
            baseViewHolder.setImageDrawable(R.id.iv_like, mContext.getResources().getDrawable(R.mipmap.ic_show_n));
        } else {
            baseViewHolder.setImageDrawable(R.id.iv_like, mContext.getResources().getDrawable(R.mipmap.ic_show_y));
        }
        baseViewHolder.addOnClickListener(R.id.iv_like);
    }

}