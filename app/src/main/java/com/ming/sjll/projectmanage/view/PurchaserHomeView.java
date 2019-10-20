package com.ming.sjll.projectmanage.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.projectmanage.bean.ZhaoRenBean;

import java.util.List;

public interface PurchaserHomeView extends MvpView {
    void ShowDate(List<ZhaoRenBean> list);
}
