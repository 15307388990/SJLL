package com.ming.sjll.my.view;


import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.ColumnDetailsBean;
import com.ming.sjll.my.bean.HomePageBean;

public interface ColumnDetailsDataView extends MvpView {
    void ShowData(ColumnDetailsBean pBean);

    void collectColumn(BaseBean bean);
}
