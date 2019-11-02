package com.ming.sjll.supplier.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.supplier.bean.HomeColumBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-24 15:45
 */
public class SupplierHomeAdapter extends BaseQuickAdapter<HomeColumBean.DataBean, BaseViewHolder> {

    public SupplierHomeAdapter(@Nullable List<HomeColumBean.DataBean> data) {
        super(R.layout.supplier_home_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, HomeColumBean.DataBean dataBean) {
        ImageHelper.displayUser((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getIcon());
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());

    }

}