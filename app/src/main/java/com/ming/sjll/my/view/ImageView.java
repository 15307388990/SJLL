package com.ming.sjll.my.view;


import com.lzy.okgo.model.Progress;
import com.lzy.okgo.model.Response;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.CompanyBean;

public interface ImageView extends MvpView {
    void uploadProgress(Progress progress);
    void onSuccess(Response<String> response);
}
