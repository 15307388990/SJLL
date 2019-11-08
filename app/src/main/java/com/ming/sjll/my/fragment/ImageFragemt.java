package com.ming.sjll.my.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.my.adapter.ImageAdapter;
import com.ming.sjll.my.presenter.MyPresenter;
import com.ming.sjll.my.presenter.PersonalDataPresenter;
import com.ming.sjll.my.view.MyView;


import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-11-01 11:37
 * 图片列表
 */

public class ImageFragemt extends MvpFragment<MvpView, MvpPresenter<MvpView>> implements MvpView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<String> strings;
    ImageView ivAdd;
    private boolean isFinal;
    private ImageAdapter imageAdapter;


    public static ImageFragemt newInstance() {
        return new ImageFragemt();
    }

    /**
     * @param strings
     * @param isFinal false为最后一页
     */
    public ImageFragemt setList(List<String> strings, boolean isFinal) {
        this.strings = strings;
        this.isFinal = isFinal;
        return this;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_recycle);
        initView();


    }

    @Override
    protected MvpPresenter createPresenter() {
        return new MvpPresenter();
    }

    private void initView() {
        View view = LinearLayout.inflate(getActivity(), R.layout.add_item, null);
        ivAdd = view.findViewById(R.id.iv_add);
        imageAdapter = new ImageAdapter(strings);
        recyclerview.setAdapter(imageAdapter);
        if (!isFinal) {
            imageAdapter.addFooterView(view, -1, LinearLayout.HORIZONTAL);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                return 1;
            }
        });
        recyclerview.setLayoutManager(gridLayoutManager);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(getActivity())
                        .openGallery(PictureMimeType.ofImage()).maxSelectNum(15).isCamera(false)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });

    }

    @Override
    public void showLoading(String msg) {
        ToastShow.s(msg);
    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {

        ToastShow.s(msg);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


}
