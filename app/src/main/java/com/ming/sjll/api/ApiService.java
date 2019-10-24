package com.ming.sjll.api;

import com.ming.sjll.purchaser.bean.AreaBean;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.bean.HomeAdsBean;
import com.ming.sjll.supplier.bean.HomeColumBean;
import com.ming.sjll.supplier.bean.MaybeLikBean;
import com.ming.sjll.supplier.bean.TalentPushBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * api接口
 */
public interface ApiService {


    //获取城市
    @FormUrlEncoded
    @POST(Constant.GETAREA)
    Observable<AreaBean> getArea(@Field("area_id") String area_id);

    //获取职业
    @POST(Constant.GETQCCUPATION)
    Observable<OccupationBean> getOccupation();

    //获取综合列表
    @FormUrlEncoded
    @POST(Constant.GETPROJECTINTEGRATED)
    Observable<ComprehenBean> getProjectIntegrated(@Field("token") String token);

    //获取通告列表
    @FormUrlEncoded
    @POST(Constant.GETNOTICE)
    Observable<ComprehenBean> getNotice(@Field("token") String token, @Field("occupation_id") String occupation_id);

    //获取达人首页列表
    @FormUrlEncoded
    @POST(Constant.TABLENTPUSH)
    Observable<TalentPushBean> talentPush(@Field("token") String token);

    //获取通告列表
    @FormUrlEncoded
    @POST(Constant.MAYBELIKE)
    Observable<MaybeLikBean> maybeLike(@Field("token") String token);

    //首页功能栏目
    @FormUrlEncoded
    @POST(Constant.HOMECOLUM)
    Observable<HomeColumBean> getHomeColum(@Field("type") String type);

    //首页广告
    @POST(Constant.HOMEADS)
    Observable<HomeAdsBean> getHomeAds();


}
