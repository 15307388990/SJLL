package com.ming.sjll.my.view;


import com.lzy.okgo.model.Response;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.HomePageBean;

import org.json.JSONException;

public interface ComplaninView extends MvpView {
    void onSuccess(Response<String> response) throws JSONException;

}
