package com.ming.sjll.my.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.model.Response;
import com.ming.sjll.R;
import com.ming.sjll.base.activity.MvpActivity;
import com.ming.sjll.base.viewmodel.ToolbarViewModel;
import com.ming.sjll.databinding.ActivityComplainBinding;
import com.ming.sjll.my.adapter.ImageAdapter;
import com.ming.sjll.my.presenter.ComplainPresenter;
import com.ming.sjll.my.view.ComplaninView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author luoming
 * created at 2019-11-09 20:54
 * 举报
 */

public class ComplainActivity extends MvpActivity<ComplaninView, ComplainPresenter> implements ComplaninView {


    private ActivityComplainBinding viewDataBinding;
    private List<String> imgs;
    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_complain);
        viewDataBinding.setTitleViewModel(new ToolbarViewModel("提交举报证据"));
        initList();


    }


    private void initList() {
        imgs = new ArrayList<>();

        View view = LinearLayout.inflate(ComplainActivity.this, R.layout.add_item, null);
        imageAdapter = new ImageAdapter(imgs);
        imageAdapter.addFooterView(view, -1, LinearLayout.HORIZONTAL);

        viewDataBinding.recyclerview.setAdapter(imageAdapter);
        ImageView ivAdd = view.findViewById(R.id.iv_add);
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PictureSelector.create(ComplainActivity.this)
                        .openGallery(PictureMimeType.ofImage()).maxSelectNum(15).isCamera(false)
                        .forResult(PictureConfig.CHOOSE_REQUEST);
            }
        });
        viewDataBinding.tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] strings = new String[imgs.size()];
                mPresenter.userPreport(viewDataBinding.etEdit.getText().toString().trim(), imgs.toArray(strings));
            }
        });
        imageAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (view.getId() == R.id.iv_delete) {
                    imgs.remove(position);
                    imageAdapter.setNewData(imgs);
                }
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ComplainActivity.this, 3);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int i) {
                return 1;
            }
        });
        viewDataBinding.recyclerview.setLayoutManager(gridLayoutManager);


    }

    @Override
    public void onSuccess(Response<String> response) throws JSONException {
        JSONObject jsonObject = new JSONObject(response.body());
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++) {
            imgs.add((String) jsonArray.get(i));
        }
        imageAdapter.setNewData(imgs);
    }


    @Override
    public ComplainPresenter autoCreatePresenter() {
        return super.autoCreatePresenter();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                    List<File> fileList = new ArrayList<>();
                    for (LocalMedia localMedia : selectList) {
                        fileList.add(new File(localMedia.getPath()));
                    }
                    mPresenter.uploadFiles(fileList);
                    break;
            }
        }
    }

    @Override
    public void showLoading(String msg) {
        super.showLoading(msg);
        ComplainActivity.this.finish();
    }
}
