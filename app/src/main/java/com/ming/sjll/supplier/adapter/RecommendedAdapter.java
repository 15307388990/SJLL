package com.ming.sjll.supplier.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.my.bean.ColumnDetailsBean;
import com.ming.sjll.supplier.bean.TalentPushBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 相关推荐
 */
public class RecommendedAdapter extends BaseQuickAdapter<ColumnDetailsBean.DataBean.RelatedBean, BaseViewHolder> {

    public RecommendedAdapter(@Nullable List<ColumnDetailsBean.DataBean.RelatedBean> data) {
        super(R.layout.recommended_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ColumnDetailsBean.DataBean.RelatedBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getBg_img(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());

    }

}