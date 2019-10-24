package com.ming.sjll.supplier.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.supplier.bean.MaybeLikBean;
import com.ming.sjll.supplier.bean.TalentPushBean;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 达人
 */
public class MaybeLikedapter extends BaseQuickAdapter<MaybeLikBean.DataBeanX.DataBean, BaseViewHolder> {

    public MaybeLikedapter(@Nullable List<MaybeLikBean.DataBeanX.DataBean> data) {
        super(R.layout.maybelike_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MaybeLikBean.DataBeanX.DataBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getCover_img(), R.drawable.ic_launcher_background);

        StringBuilder name = new StringBuilder(dataBean.getName());
        if (dataBean.getIs_sign() == 1) {
            name.append(" · ");
            name.append(" 平台签约");
        }
        baseViewHolder.setText(R.id.tv_name, name);
        baseViewHolder.setText(R.id.tv_text, dataBean.getCollect_num()+"粉丝");


    }

}