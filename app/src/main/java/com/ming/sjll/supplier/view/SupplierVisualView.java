package com.ming.sjll.supplier.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.my.bean.ColumnListBean;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.supplier.bean.ArticleListBean;
import com.ming.sjll.supplier.bean.TopArticleBean;

public interface SupplierVisualView extends MvpView {
    void setColumnList(ColumnListBean bean);

    void setTopArticle(TopArticleBean bean);

    void getspOccupation(OccupationBean bean);
}
