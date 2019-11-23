package com.ming.sjll.my.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jet.flowtaglayout.FlowTagLayout;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.my.bean.ColletionGoodsBean;
import com.ming.sjll.my.bean.ColletionPersenterBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 收藏 商品
 */
public class CollectionGoodsAdapter extends BaseQuickAdapter<ColletionGoodsBean.DataBeanX.DataBean, BaseViewHolder> {

    public CollectionGoodsAdapter(@Nullable List<ColletionGoodsBean.DataBeanX.DataBean> data) {
        super(R.layout.collection_goods_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ColletionGoodsBean.DataBeanX.DataBean dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getImg(), R.drawable.ic_launcher_background);
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());
        baseViewHolder.setText(R.id.tv_wage, dataBean.getPayment());
        baseViewHolder.setText(R.id.tv_adds, dataBean.getAddress());


    }

}