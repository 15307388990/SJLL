package com.ming.sjll.my.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.gson.JsonObject;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.ming.sjll.R;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.fragment.MvpFragment;
import com.ming.sjll.base.widget.ToastShow;
import com.ming.sjll.my.adapter.ImageAdapter;
import com.ming.sjll.my.presenter.ImagerPresenter;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.util.List;

import butterknife.BindView;

/**
 * @author luoming
 * created at 2019-11-01 11:37
 * 图片列表
 */

public class ImageFragemt extends MvpFragment<com.ming.sjll.my.view.ImageView, ImagerPresenter> implements com.ming.sjll.my.view.ImageView {


    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    List<String> strings;
    ImageView ivAdd;
    private boolean isFinal;
    private ProgressBar progressBar;
    private ImageAdapter imageAdapter;
    private UpdateData updateData;


    public static ImageFragemt newInstance() {
        return new ImageFragemt();
    }

    /**
     * @param strings
     * @param isFinal false为最后一页
     */
    public ImageFragemt setList(List<String> strings, boolean isFinal, UpdateData updateData) {
        this.strings = strings;
        this.isFinal = isFinal;
        this.updateData = updateData;
        return this;
    }

    @Override
    protected void onCreateView(Bundle savedInstanceState) {
        super.onCreateView(savedInstanceState);
        setContentView(R.layout.fragemt_recycle);
        initView();


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
        //初始化进度条
        progressBar = new ProgressBar(getActivity());

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == getActivity().RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片、视频、音频选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    // 例如 LocalMedia 里面返回三种path
                    // 1.media.getPath(); 为原图path
                    // 2.media.getCutPath();为裁剪后path，需判断media.isCut();是否为true  注意：音视频除外
                    // 3.media.getCompressPath();为压缩后path，需判断media.isCompressed();是否为true  注意：音视频除外
                    // 如果裁剪并压缩了，以取压缩路径为准，因为是先裁剪后压缩的
                   uploadFiles(selectList);
                    break;
            }
        }
    }

    @Override
    protected ImagerPresenter createPresenter() {
        return new ImagerPresenter();
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


    @Override
    public void uploadProgress(Progress progress) {
        progressBar.setProgress((int) progress.currentSize);
        progressBar.setMax((int) progress.totalSize);
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void onSuccess(Response<String> response) throws JSONException {
        progressBar.setVisibility(View.GONE);
        JSONObject jsonObject = new JSONObject(response.body());
        strings.add(jsonObject.getString("data"));
        updateData.add(strings);
    }

    public interface UpdateData {
        void add(List<String> list);

    }
    public void uploadFiles(List<LocalMedia> selectList) {
        //写一个递归
        String file = selectList.get(0).getPath();
        OkGo.<String>post(Constant.BASE_API + Constant.UPLOAD)//
                .tag(this)//
                //.isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                //.params("param1", "paramValue1")        // 这里可以上传参数
                .params("image", new File(file))   // 可以添加文件上传
                //.params("file2", new File("filepath2"))     // 支持多文件同时添加上传
                //.addFileParams(keyName, (List<File>) file)    // 这里支持一个key传多个文件
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                           ImageFragemt.this.onSuccess(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFinish() {
                        super.onFinish();
                        selectList.remove(0);
                        if (selectList.size() > 0) {
                            uploadFiles(selectList);
                        } else {
                            return;
                        }

                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress(progress);
                        //getView().uploadProgress(progress);


                    }
                });
    }
}
