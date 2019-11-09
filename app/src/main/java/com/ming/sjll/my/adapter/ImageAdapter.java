package com.ming.sjll.my.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.ImageHelper;


import java.util.List;


/**
 * @author luoming
 * created at 2019-10-27 16:08
 */
public class ImageAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    public ImageAdapter(@Nullable List<String> data) {
        super(R.layout.imgview_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String dataBean) {
        ImageHelper.displayBackground((ImageView) baseViewHolder.getView(R.id.iv_img), Constant.BASE_API + dataBean, R.mipmap.ic_launcher);
        baseViewHolder.addOnClickListener(R.id.iv_delete);
    }

}