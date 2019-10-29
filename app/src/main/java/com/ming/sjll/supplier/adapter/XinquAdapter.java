package com.ming.sjll.supplier.adapter;

import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;
import com.ming.sjll.supplier.bean.MaybeLikBean;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 达人
 */
public class XinquAdapter extends BaseQuickAdapter<MaybeLikBean.DataBean, BaseViewHolder> {

    public XinquAdapter(@Nullable List<MaybeLikBean.DataBean> data) {
        super(R.layout.supplier_talent_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MaybeLikBean.DataBean dataBean) {

        baseViewHolder.setText(R.id.tv_xinqu, dataBean.getTitle());

        RecyclerView recyclerview = baseViewHolder.getView(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(layoutManager);
        recyclerview.setAdapter(new MaybeLikedapter(dataBean.getList()));
    }

}