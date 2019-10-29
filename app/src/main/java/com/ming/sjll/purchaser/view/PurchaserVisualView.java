package com.ming.sjll.purchaser.view;


import com.ming.sjll.base.view.MvpView;
import com.ming.sjll.supplier.bean.ArticleListBean;
import com.ming.sjll.supplier.bean.TopArticleBean;

public interface PurchaserVisualView extends MvpView {
    void setArticleList(ArticleListBean bean);

    void setTopArticle(TopArticleBean bean);
}
