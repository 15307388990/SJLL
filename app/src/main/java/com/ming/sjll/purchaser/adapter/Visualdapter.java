package com.ming.sjll.purchaser.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.supplier.bean.ArticleListBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 视觉
 */
public class Visualdapter extends BaseQuickAdapter<ArticleListBean.DataBeanX.DataBean, BaseViewHolder> {

    public Visualdapter(@Nullable List<ArticleListBean.DataBeanX.DataBean> data) {
        super(R.layout.visual_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ArticleListBean.DataBeanX.DataBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getCover_img(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());
        baseViewHolder.setText(R.id.tv_timer, Tools.getDateformat(dataBean.getCreated_time()));
        baseViewHolder.setText(R.id.tv_number,dataBean.getRead_num()+"");

    }

}