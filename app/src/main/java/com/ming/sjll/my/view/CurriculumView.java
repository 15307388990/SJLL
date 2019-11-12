package com.ming.sjll.my.view;


import com.lzy.okgo.model.Response;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.CurriculumBean;
import com.ming.sjll.my.bean.HomePageBean;

import org.json.JSONException;

public interface CurriculumView extends MvpView {
    void ShowData(CurriculumBean pBean);

}
