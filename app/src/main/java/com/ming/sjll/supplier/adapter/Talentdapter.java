package com.ming.sjll.supplier.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.supplier.bean.TalentPushBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 达人
 */
public class Talentdapter extends BaseQuickAdapter<TalentPushBean.DataBean, BaseViewHolder> {

    public Talentdapter(@Nullable List<TalentPushBean.DataBean> data) {
        super(R.layout.talent_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, TalentPushBean.DataBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getCover_img(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_name, dataBean.getName());
        if (dataBean.getTags().size() > 0) {
            baseViewHolder.setText(R.id.tv_tag1, dataBean.getTags().get(0));
            baseViewHolder.setVisible(R.id.tv_tag1, true);
            if (dataBean.getTags().size() > 1) {
                baseViewHolder.setText(R.id.tv_tag2, dataBean.getTags().get(1));
                baseViewHolder.setVisible(R.id.tv_tag2, true);
            } else {
                baseViewHolder.setVisible(R.id.tv_tag2, false);
            }
        } else {
            baseViewHolder.setVisible(R.id.tv_tag1, false);
            baseViewHolder.setVisible(R.id.tv_tag2, false);
        }
        StringBuilder text = new StringBuilder();
        for (String zhi : dataBean.getOccupation()) {
            text.append(zhi);
            text.append(" · ");
        }
        text.append(dataBean.getCity_name());
        text.append(" · ");
        text.append(dataBean.getPayment_hour());
        text.append("/h");
        baseViewHolder.setText(R.id.tv_text, text);
        // text.append(dataBean.get)

    }

}