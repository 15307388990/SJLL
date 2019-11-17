package com.ming.sjll.api;

import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.loginreg.bean.LoginBean;
import com.ming.sjll.loginreg.bean.RegistereBean;
import com.ming.sjll.message.viewmodel.ApplyPassBean;
import com.ming.sjll.message.viewmodel.CompanyApplyBean;
import com.ming.sjll.message.viewmodel.CompanyPassBean;
import com.ming.sjll.message.viewmodel.CooperationBean;
import com.ming.sjll.message.viewmodel.GetChatProjectBean;
import com.ming.sjll.message.viewmodel.InvitePassBean;
import com.ming.sjll.message.viewmodel.MessageNotifyBean;
import com.ming.sjll.message.viewmodel.MessageProjectCoordinationViewModel;
import com.ming.sjll.message.viewmodel.ProjectChatViewModel;
import com.ming.sjll.message.viewmodel.ProjectInviteBean;
import com.ming.sjll.message.viewmodel.SetChatProjectBean;
import com.ming.sjll.my.bean.AdsBean;
import com.ming.sjll.my.bean.ColumnDetailsBean;
import com.ming.sjll.my.bean.ColumnListBean;
import com.ming.sjll.my.bean.CompanyBean;
import com.ming.sjll.my.bean.CurriculumBean;
import com.ming.sjll.my.bean.HomePageBean;
import com.ming.sjll.my.bean.PersonalDateBean;
import com.ming.sjll.purchaser.bean.AreaBean;
import com.ming.sjll.purchaser.bean.OccupationBean;
import com.ming.sjll.purchaser.bean.ProjectManagementBean;
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
    @FormUrlEncoded
    @POST(Constant.TOPARTICLE)
    Observable<TopArticleBean> getTopArtic(@Field("type") String type);

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
    Observable<RegistereBean> register(@Field("phone") String phone, @Field("password") String password, @Field("code") String code, @Field("repassword") String repassword);


    /**
     * 发送验证码
     *
     * @param phone
     * @param type  type   类型
     *              *                      loginCode :  快速登陆验证码
     *              *                      registerCode :  注册验证码
     *              *                      ChangeLoginPwd : 忘记密码
     * @return
     */
    @FormUrlEncoded
    @POST(Constant.SENDCODE)
    Observable<BaseBean> sendcode(@Field("phone") String phone, @Field("type") String type);

    //登录
    @FormUrlEncoded
    @POST(Constant.LOGIN)
    Observable<LoginBean> login(@Field("phone") String phone, @Field("password") String password);


    //快速登录
    @FormUrlEncoded
    @POST(Constant.QUICKLOGIN)
    Observable<LoginBean> quickLogin(@Field("phone") String phone, @Field("code") String code);


    //判断用户认证类型(基础资料)
    @FormUrlEncoded
    @POST(Constant.ISAPPROVECOMPANY)
    Observable<CompanyBean> getIsApprove(@Field("token") String token);

    //个人(公司)作品列表
    @FormUrlEncoded
    @POST(Constant.GETWORKSLIST)
    Observable<PersonalDateBean> getWorksList(@Field("token") String token);

    //项目详情
    @FormUrlEncoded
    @POST(Constant.PROJECTINFO)
    Observable<ProjectChatViewModel> getProjectInfo(@Field("token") String token, @Field("project_id") String project_id);

    //删除作品
    @FormUrlEncoded
    @POST(Constant.DELWORK)
    Observable<BaseBean> delWork(@Field("token") String token, @Field("work_id") String work_id);

    //个人主页
    @FormUrlEncoded
    @POST(Constant.USERCENTER)
    Observable<HomePageBean> usercenter(@Field("token") String token, @Field("uid") String uid);


    //收藏用户
    @FormUrlEncoded
    @POST(Constant.COLLECTUSER)
    Observable<BaseBean> collectuser(@Field("token") String token, @Field("uid") String uid);

    //举报用户
    @FormUrlEncoded
    @POST(Constant.USERREPORT)
    Observable<BaseBean> userPreport(@Field("token") String token, @Field("report_uid") String uid, @Field("content") String content, @Field("img[]") String img[]);


    //我的订单*业务
    @FormUrlEncoded
    @POST(Constant.GETBUSINESS)
    Observable<ProjectManagementBean> getBusiness(@Field("token") String token, @Field("status") String status);

    //我的订单*课程
    @FormUrlEncoded
    @POST(Constant.CURRICULUM)
    Observable<CurriculumBean> getCurriculum(@Field("token") String token);

    //我的订单*投广
    @FormUrlEncoded
    @POST(Constant.GETADS)
    Observable<AdsBean> getAds(@Field("token") String token, @Field("status") String status);

    //获取专栏职业
    @FormUrlEncoded
    @POST(Constant.SPQCCUPATION)
    Observable<OccupationBean> getspOccupation(@Field("token") String token);

    //获取专栏列表
    @FormUrlEncoded
    @POST(Constant.COLUMNLIST)
    Observable<ColumnListBean> columnList(@Field("token") String token);

    //获取专栏详情
    @FormUrlEncoded
    @POST(Constant.GETCOLUMNINFO)
    Observable<ColumnDetailsBean> getColumnInfo(@Field("token") String token, @Field("column_id") String column_id);

    //收藏课程(专栏)
    @FormUrlEncoded
    @POST(Constant.COLLECTCOLUMN)
    Observable<BaseBean> collectColumn(@Field("token") String token, @Field("column_id") String column_id);

    //项目管理
    @FormUrlEncoded
    @POST(Constant.PROJECTMANAGE)
    Observable<ProjectManagementBean> projectManage(@Field("token") String token, @Field("type") String type);


    //通知(未读)
    @FormUrlEncoded
    @POST(Constant.UNREADMSG)
    Observable<MessageNotifyBean> unReadmsg(@Field("token") String token);


    //项目统筹列表
    @FormUrlEncoded
    @POST(Constant.PROJECTAPPLY)
    Observable<MessageProjectCoordinationViewModel> projectApply(@Field("token") String token, @Field("page") String page, @Field("pageSize") String pageSize);

    //项目参与确认列表
    @FormUrlEncoded
    @POST(Constant.PROJECTINVITE)
    Observable<ProjectInviteBean> projectInvite(@Field("token") String token, @Field("page") String page, @Field("pageSize") String pageSize);

    //公司申请列表
    @FormUrlEncoded
    @POST(Constant.COMPANYAPPLY)
    Observable<CompanyApplyBean> companyApply(@Field("token") String token, @Field("page") String page, @Field("pageSize") String pageSize);


    //项目统筹申请(是否同意)
    @FormUrlEncoded
    @POST(Constant.APPLYPASS)
    Observable<ApplyPassBean> applyPass(@Field("token") String token, @Field("apply_id") String apply_id, @Field("status") String status);


    //项目参与确认(是否同意)
    @FormUrlEncoded
    @POST(Constant.INVITEPASS)
    Observable<InvitePassBean> invitePass(@Field("token") String token, @Field("apply_id") String apply_id, @Field("status") String status);

    //公司申请(是否同意)
    @FormUrlEncoded
    @POST(Constant.COMPANYPASS)
    Observable<CompanyPassBean> companyPass(@Field("token") String token, @Field("apply_id") String apply_id, @Field("status") String status);


    //公司申请(是否同意)
    @FormUrlEncoded
    @POST(Constant.SETCHATPROJECT)
    Observable<SetChatProjectBean> setChatProject(@Field("token") String token, @Field("userId") String userId, @Field("project_id") String project_id);


    //获取单聊正在谈的项目
    @FormUrlEncoded
    @POST(Constant.GETCHATPROJECT)
    Observable<GetChatProjectBean> getChatProject(@Field("token") String token, @Field("userId") String userId);


    //确认合作发送的请求
    @FormUrlEncoded
    @POST(Constant.COOPERATION)
    Observable<CooperationBean> cooperation(@Field("token") String token, @Field("userId") String userId, @Field("project_id") String project_id);


}

