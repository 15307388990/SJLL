package com.ming.sjll.my.presenter;

import android.os.Bundle;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.ming.sjll.api.ApiService;
import com.ming.sjll.api.Constant;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.dialog.EditorDataDialog;
import com.ming.sjll.my.view.ComplaninView;
import com.ming.sjll.my.view.HomeageDataView;

import org.json.JSONException;

import java.io.File;
import java.util.List;

public class ComplainPresenter extends MvpPresenter<ComplaninView> {
    public static String REPORTUID = "report_uid";
    private String report_uid;

    @Override
    public void attachView(ComplaninView view, Bundle bundle) {
        super.attachView(view, bundle);
        report_uid = bundle.getString("REPORTUID");
    }

    public void userPreport(String content, String[] imgs) {

        getNetData(RetrofitManager.get().create(ApiService.class).userPreport(getToken(), report_uid, content, imgs),
                new ApiObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean data) {
                        getView().showLoading(data.getMsg());

                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);

                    }
                });
    }
    //上传图片
    public void uploadFiles(List<File> selectList) {
        OkGo.<String>post(Constant.BASE_API + Constant.UPLOADIMG)//
                .tag(this)//
                //.isMultipart(true)       // 强制使用 multipart/form-data 表单上传（只是演示，不需要的话不要设置。默认就是false）
                //.params("param1", "paramValue1")        // 这里可以上传参数
                //.params("image", new File(file))   // 可以添加文件上传
                //.params("file2", new File("filepath2"))     // 支持多文件同时添加上传
                .addFileParams("image[]", selectList)    // 这里支持一个key传多个文件
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
                    }

                    @Override
                    public void onError(Response<String> response) {
                        super.onError(response);
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress(progress);


                    }
                });
    }


}
