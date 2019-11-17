package com.ming.sjll.my.presenter;

import android.os.Bundle;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.ColumnDetailsBean;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.view.ColumnDetailsDataView;
import com.ming.sjll.my.view.HomeageDataView;

public class ColumnDetailsPresenter extends MvpPresenter<ColumnDetailsDataView> {
    private String column_id;

    @Override
    public void attachView(ColumnDetailsDataView view, Bundle bundle) {
        super.attachView(view, bundle);
        column_id = bundle.getString("column_id");
        getColumnInfo(column_id);
    }

    public void getColumnInfo(String column_id) {
        this.column_id = column_id;

        getNetData(RetrofitManager.get().create(ApiService.class).getColumnInfo(getToken(), column_id),
                new ApiObserver<ColumnDetailsBean>() {
                    @Override
                    public void onSuccess(ColumnDetailsBean data) {
                        getView().ShowData(data);
                    }

                    @Override
                    public void onFailure(int code, String msg) {

                    }
                });
    }

    public void collectColumn() {
        getNetData(RetrofitManager.get().create(ApiService.class).collectColumn(getToken(), column_id),
                new ApiObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean data) {
                        getView().collectColumn(data);
                    }

                    @Override
                    public void onFailure(int code, String msg) {

                    }
                });
    }


}
