package com.ming.sjll.my.adapter;

import android.app.Activity;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jet.flowtaglayout.FlowTagLayout;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.entity.LocalMedia;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.utils.Tools;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.bean.PersonalDateBean;

import java.util.ArrayList;
import java.util.List;


/**
 * @author luoming
 * created at 2019-10-27 16:08
 */
public class HomePageDataAdapter extends BaseQuickAdapter<HomePageBean.DataBean.WorkBean, BaseViewHolder> {

    public HomePageDataAdapter(@Nullable List<HomePageBean.DataBean.WorkBean> data) {
        super(R.layout.home_page_data_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder,HomePageBean.DataBean.WorkBean dataBean) {
        baseViewHolder.setText(R.id.tv_title, dataBean.getTitle());
        baseViewHolder.setText(R.id.tv_describe, dataBean.getDescribe());
        baseViewHolder.setText(R.id.tv_day, Tools.getDateformat3(dataBean.getCreated_time(), "dd"));
        baseViewHolder.setText(R.id.tv_describe, Tools.getDateformat3(dataBean.getCreated_time(), "MM") + "月");
        RecyclerView recyclerView = baseViewHolder.getView(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        PersonalImageAdapter personalImageAdapter = new PersonalImageAdapter(dataBean.getImgList());
        List<LocalMedia> selectList = new ArrayList<>();
        for (String img : dataBean.getImgList()) {
            LocalMedia localMedia = new LocalMedia(Constant.BASE_API + img, 0, 1, "image/jpeg");
            selectList.add(localMedia);
        }
        personalImageAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_img) {
                    PictureSelector.create((Activity) mContext).themeStyle(R.style.picture_default_style).openExternalPreview(position, selectList);
                }
            }
        });
        recyclerView.setAdapter(personalImageAdapter);
        FlowTagLayout flowTagLayout = baseViewHolder.getView(R.id.flowTagLayout);
        flowTagLayout.addTags(dataBean.getTagsList());
        baseViewHolder.addOnClickListener(R.id.ll_heart);

    }

}