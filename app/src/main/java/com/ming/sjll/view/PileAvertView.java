package com.ming.sjll.view;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.ming.sjll.R;
import com.ming.sjll.base.utils.ImageLoaderUtil;
import com.ming.sjll.databinding.ItemGroupRoundAvertBinding;
import com.ming.sjll.databinding.LayoutGroupPileAvertBinding;

import java.util.List;

/**
 * <p>Created by gizthon on 2019-09-07. email:2013mzhou@gmail.com</p>
 * <p>
 * des:
 */
public class PileAvertView extends LinearLayout {

    private LayoutGroupPileAvertBinding binding;
    private Context context = null;
    public static final int VISIBLE_COUNT = 3;//默认显示个数

    public PileAvertView(Context context) {
        this(context, null);
        this.context = context;
    }

    public PileAvertView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
    }

    private void initView() {
        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.layout_group_pile_avert, this, true);

    }

    @BindingAdapter({"pileImages"})
    public static void setAvertImages(PileAvertView view, List<String> imageList) {
        if(imageList == null || imageList.isEmpty()){
            return;
        }
        view.setAvertImages(imageList, VISIBLE_COUNT);
    }

    //如果imageList>visiableCount,显示List最上面的几个
    public void setAvertImages(List<String> imageList, int visibleCount) {
        if (imageList == null || imageList.isEmpty()){
            return;
        }
        List<String> visibleList = null;
        if (imageList.size() > visibleCount) {
            visibleList = imageList.subList(imageList.size() - 1 - visibleCount, imageList.size() - 1);
        }else {
            visibleList = imageList;
        }
        if (visibleList == null || visibleList.isEmpty()){
            return;
        }

        binding.pileView.removeAllViews();
        for (int i = 0; i < visibleList.size(); i++) {
            ItemGroupRoundAvertBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_group_round_avert, binding.pileView, false);

            if (visibleList.size() - 1 == i){//最后一条使用更多的图片
                ImageLoaderUtil.display(dataBinding.circleView,R.mipmap.message_group_header_more);
            }else {
                ImageLoaderUtil.display(dataBinding.circleView,imageList.get(i));
            }

            binding.pileView.addView(dataBinding.getRoot());
        }
    }

}