package com.ming.sjll.my.presenter;

import com.luck.picture.lib.entity.LocalMedia;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.adapter.Call;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.ming.sjll.api.ApiService;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.CompanyBean;
import com.ming.sjll.my.view.ImageView;

import org.json.JSONException;

import java.io.File;
import java.util.List;


public class ImagerPresenter extends MvpPresenter<ImageView> {

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
                            getView().onSuccess(response);
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
