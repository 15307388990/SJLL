package com.ming.sjll.supplier.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.supplier.bean.MaybeLikBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 达人
 */
public class MaybeLikedapter extends BaseQuickAdapter<MaybeLikBean.DataBean.ListBean, BaseViewHolder> {

    public MaybeLikedapter(@Nullable List<MaybeLikBean.DataBean.ListBean> data) {
        super(R.layout.maybelike_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MaybeLikBean.DataBean.ListBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getCover_img(), R.drawable.ic_launcher_background);

        StringBuilder name = new StringBuilder(dataBean.getName());
        if (dataBean.getIs_sign() == 1) {
            name.append(" · ");
            name.append(" 平台签约");
        }
        baseViewHolder.setText(R.id.tv_name, name);
        baseViewHolder.setText(R.id.tv_text, dataBean.getCollect_num() + "粉丝");
        TextView textView = baseViewHolder.getView(R.id.tv_guanzhu);
        if (dataBean.getIs_approve() == 1) {
            textView.setText("已关注");
            textView.setBackgroundResource(R.drawable.ic_publish2);
        } else {
            textView.setText("关注");
            textView.setBackgroundResource(R.drawable.ic_introduction2);
        }
        baseViewHolder.addOnClickListener(R.id.tv_guanzhu);
        baseViewHolder.addOnClickListener(R.id.iv_img);
    }

}