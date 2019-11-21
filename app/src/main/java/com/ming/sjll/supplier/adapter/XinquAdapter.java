package com.ming.sjll.supplier.adapter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ming.sjll.R;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.activity.HomeageActivity;
import com.ming.sjll.supplier.bean.MaybeLikBean;

import java.util.List;


/**
 * @author luoming
 * created at 2019-10-22 17:01
 * 达人
 */
public class XinquAdapter extends BaseQuickAdapter<MaybeLikBean.DataBean, BaseViewHolder> {
    private AddFocus addFocus;

    public XinquAdapter(@Nullable List<MaybeLikBean.DataBean> data, AddFocus addFocus) {
        super(R.layout.supplier_talent_item, data);
        this.addFocus = addFocus;
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, MaybeLikBean.DataBean dataBean) {

        baseViewHolder.setText(R.id.tv_xinqu, dataBean.getTitle());

        RecyclerView recyclerview = baseViewHolder.getView(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerview.setLayoutManager(layoutManager);
        MaybeLikedapter maybeLikedapter = new MaybeLikedapter(dataBean.getList());
        recyclerview.setAdapter(maybeLikedapter);
        maybeLikedapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.iv_img:
                        Bundle bundle = new Bundle();
                        bundle.putString("uid", dataBean.getList().get(position).getId() + "");
                        Tools.jump((Activity) mContext, HomeageActivity.class, bundle, false);
                        break;
                    case R.id.tv_guanzhu:
                        addFocus.addFocus(dataBean.getList().get(position).getId() + "");
                        if (dataBean.getList().get(position).getIs_approve() == 1) {
                            dataBean.getList().get(position).setIs_approve(0);
                        } else {
                            dataBean.getList().get(position).setIs_approve(1);
                        }
                        maybeLikedapter.notifyItemChanged(position);
                        break;
                }
            }
        });

    }

    public interface AddFocus {
        void addFocus(String focus_user_id);
    }

}