package com.ming.sjll.supplier.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.supplier.bean.CikunmBean;

import java.util.List;

import androidx.annotation.Nullable;

/**
 * @author luoming
 * created at 2019-10-24 15:45
 */
public class JieWuAdapter extends BaseQuickAdapter<CikunmBean.DataBean.ThingsBean, BaseViewHolder> {

    public JieWuAdapter(@Nullable List<CikunmBean.DataBean.ThingsBean> data) {
        super(R.layout.supplier_home_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, CikunmBean.DataBean.ThingsBean dataBean) {
        ImageHelper.displayUser((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean.getIcon());
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());

    }

}