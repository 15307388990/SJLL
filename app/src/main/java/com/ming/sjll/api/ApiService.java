package com.ming.sjll.api;

import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.purchaser.bean.AreaBean;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.show.bean.ShowWorkBean;
import com.ming.sjll.supplier.bean.ArticleListBean;
import com.ming.sjll.supplier.bean.CikunmBean;
import com.ming.sjll.supplier.bean.ComprehenBean;
import com.ming.sjll.supplier.bean.HomeAdsBean;
import com.ming.sjll.supplier.bean.HomeColumBean;
import com.ming.sjll.supplier.bean.HotArticleBean;
import com.ming.sjll.supplier.bean.HotAuthorBean;
import com.ming.sjll.supplier.bean.MaybeLikBean;
import com.ming.sjll.supplier.bean.TalentPushBean;
import com.ming.sjll.supplier.bean.TopArticleBean;

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

    //获取感兴趣的人列表
    @FormUrlEncoded
    @POST(Constant.MAYBELIKE)
    Observable<MaybeLikBean> maybeLike(@Field("token") String token, @Field("type") String type);

    //首页功能栏目
    @FormUrlEncoded
    @POST(Constant.HOMECOLUM)
    Observable<HomeColumBean> getHomeColum(@Field("type") String type);

    //首页广告
    @POST(Constant.HOMEADS)
    Observable<HomeAdsBean> getHomeAds();

    //置顶文章
    @POST(Constant.TOPARTICLE)
    Observable<TopArticleBean> getTopArtic();

    //热门文章
    @POST(Constant.HOTARTICLE)
    Observable<HotArticleBean> getHotArticle();

    //热门作者
    @POST(Constant.HOTAUTHOR)
    Observable<HotAuthorBean> getHotAuthor();

    //文章列表
    @POST(Constant.ARTICLELIST)
    Observable<ArticleListBean> getArticleList();

    //找人找物
    @POST(Constant.GETCOLUMCHILD)
    Observable<CikunmBean> getColunmChild();

    //找人找物
    @FormUrlEncoded
    @POST(Constant.WORK)
    Observable<ShowWorkBean> getShowWork(@Field("token") String token);

    //收藏
    @FormUrlEncoded
    @POST(Constant.WORKCOLLECT)
    Observable<BaseBean> workCollect(@Field("token") String token, @Field("work_id") String work_id);

    //注册
    @FormUrlEncoded
    @POST(Constant.REGISTER)
    Observable<BaseBean> register(@Field("phone") String phone, @Field("password") String password, @Field("code") String code, @Field("repassword") String repassword);


    /**
     * 发送验证码
     * @param phone
     * @param type type   类型
     * *                      loginCode :  快速登陆验证码
     * *                      registerCode :  注册验证码
     * *                      ChangeLoginPwd : 忘记密码
     * @return
     */
    @FormUrlEncoded
    @POST(Constant.SENDCODE)
    Observable<BaseBean> sendcode(@Field("phone") String phone,@Field("type") String type);

    //登录
    @FormUrlEncoded
    @POST(Constant.LOGIN)
    Observable<LoginBean> login(@Field("phone") String phone, @Field("password") String password);


    //快速登录
    @FormUrlEncoded
    @POST(Constant.QUICKLOGIN)
    Observable<LoginBean> quickLogin(@Field("phone") String phone, @Field("code") String code);


}
