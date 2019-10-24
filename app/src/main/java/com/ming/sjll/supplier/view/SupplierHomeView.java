package com.ming.sjll.supplier.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.purchaser.bean.AreaBean;
import com.ming.sjll.supplier.bean.HomeAdsBean;
import com.ming.sjll.supplier.bean.HomeColumBean;

import java.util.List;

public interface SupplierHomeView extends MvpView {
    void ShowDate(HomeColumBean homeColumBean);

    void ShowImg(HomeAdsBean bean);
}
