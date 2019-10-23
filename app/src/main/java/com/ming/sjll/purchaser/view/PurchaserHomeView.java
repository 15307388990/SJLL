package com.ming.sjll.purchaser.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.purchaser.bean.AreaBean;

import java.util.List;

public interface PurchaserHomeView extends MvpView {
    void ShowDate(List<AreaBean> list);
}
