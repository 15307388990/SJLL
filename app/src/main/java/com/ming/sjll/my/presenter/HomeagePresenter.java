package com.ming.sjll.my.presenter;

import com.ming.sjll.api.ApiService;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.exp.RetrofitManager;
import com.ming.sjll.base.http.ApiObserver;
import com.ming.sjll.base.presenter.MvpPresenter;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.my.view.HomeageDataView;
import com.ming.sjll.my.view.PersonalDataView;

public class HomeagePresenter extends MvpPresenter<HomeageDataView> {
    public void getWorksList() {

        getNetData(RetrofitManager.get().create(ApiService.class).getWorksList("2e9f39acab38ffd042c4baf9f8c75cb7f5cecb26"),
                new ApiObserver<PersonalDateBean>() {
                    @Override
                    public void onSuccess(PersonalDateBean data) {
                        getView().ShowData(data);
                    }

                    @Override
                    public void onFailure(int code, String msg) {

                    }
                });
    }

    public void delWork(String work_id) {
        getNetData(RetrofitManager.get().create(ApiService.class).delWork("2e9f39acab38ffd042c4baf9f8c75cb7f5cecb26",work_id),
                new ApiObserver<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean data) {
                        //删除成功，重新刷新列表
                        getView().showLoading(data.getMsg());
                        getWorksList();
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        getView().showError(msg);

                    }
                });
    }
}
