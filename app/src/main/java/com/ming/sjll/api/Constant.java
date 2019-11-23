package com.ming.sjll.api;


public class Constant {
    public static final String BASE_API = "http://www.jietest.site/";

    /**
     * 图片上传
     */
    public static final String UPLOAD = "/api/common/upload";
    /**
     * 多图片上传
     */
    public static final String UPLOADIMG = "/api/common/uploadImg";

    /**
     * 获取城市
     */

    public static final String GETAREA = "/api/common/getArea";

    /**
     * 获取职业
     */

    public static final String GETQCCUPATION = "/api/home/getOccupation";
    /**
     * 综合
     */
    public static final String GETPROJECTINTEGRATED = "/api/project/projectIntegrated";
    /**
     * 通告
     */
    public static final String GETNOTICE = "/api/project/projectNotice";

    /**
     * 达人
     */
    public static final String TABLENTPUSH = "/api/home/talentPush";
    /**
     * 可能感兴趣的用户
     */
    public static final String MAYBELIKE = "/api/show/maybeLike";
    /**
     * 首页功能栏目
     */
    public static final String HOMECOLUM = "/api/home/getHomeColunm";

    /**
     * 首页功能栏目
     */
    public static final String HOMEADS = "/api/home/homeAds";

    /**
     * 置顶文章
     */
    public static final String TOPARTICLE = "/api/home/topArticle";

    /**
     * 热门文章
     */
    public static final String HOTARTICLE = "/api/home/hotArticle";

    /**
     * 热门作者
     */
    public static final String HOTAUTHOR = "/api/home/hotAuthor";

    /**
     * 文章列表
     */
    public static final String ARTICLELIST = "/api/home/articleList";

    /**
     * 文章列表
     */
    public static final String COLUMNLIST = "/api/special_column/columnList";


    /**
     * 找人找物
     */
    public static final String GETCOLUMCHILD = "api/home/getColunmChild";

    /**
     * show 列表
     */
    public static final String WORK = "/api/show/work";

    /**
     * 收藏
     */
    public static final String WORKCOLLECT = "/api/show/workCollect";

    /**
     * 注册
     */
    public static final String REGISTER = "api/user/register";

    /**
     * 发送验证码
     */
    public static final String SENDCODE = "/api/user/sendCode";

    /**
     * 登录
     */
    public static final String LOGIN = "/api/user/login";

    /**
     * 快速登录
     */
    public static final String QUICKLOGIN = "/api/user/quickLogin";

    /**
     * 判断用户认证类型(基础资料)
     */
    public static final String ISAPPROVECOMPANY = "/api/personal_center/isApproveCompany";

    /**
     * 个人(公司)作品列表
     */
    public static final String GETWORKSLIST = "/api/personal_center/getWorksList";

    /**
     * 项目详情
     */
    public static final String PROJECTINFO = "/api/project/projectInfo";

    /**
     * 删除作品
     */
    public static final String DELWORK = "/api/personal_center/delWork";

    /**
     * 个人主页
     */
    public static final String USERCENTER = "/api/personal_center/userCenter";

    /**
     * 收藏用户
     */
    public static final String COLLECTUSER = "/api/collect/collectUser";

    /**
     * 举报用户
     */
    public static final String USERREPORT = "/api/user_report/user";


    /**
     * 项目管理
     */
    public static final String PROJECTMANAGE = "/api/project/projectManage";

    /**
     * 我的订单*业务
     */
    public static final String GETBUSINESS = "/api/order/getBusiness";

    /**
     * 我的订单*课程
     */

    public static final String CURRICULUM = "/api/order/curriculum";

    /**
     * 我的订单*投广
     */
    public static final String GETADS = "/api/order/getAds";

    /**
     * 获取专栏职业
     */
    public static final String SPQCCUPATION = "/api/special_column/getOccupation";

    /**
     * 获取专栏详情
     */
    public static final String GETCOLUMNINFO = "/api/special_column/getColumnInfo";

    /**
     * 收藏课程(专栏)
     */
    public static final String COLLECTCOLUMN = "/api/collect/collectColumn";

    /**
     * 客服中心
     */
    public static final String USERLEAVEMSG = "/api/personal_center/userLeaveMsg";

    /**
     * APP更新
     */
    public static final String GETVERSION = "/api/common/getVersion";

    /**
     *发送验证码(重置密码)
     */
    public static final String SAVECODE = "/api/personal_center/saveCode";

    /**
     *重置密码
     */
    public static final String SAVEPWD = "/api/personal_center/savePwd";



    /**
     * 通知(未读)
     */
    public static final String UNREADMSG = "/api/Inform/unreadMsg";

    /**
     * 项目统筹列表
     */
    public static final String PROJECTAPPLY = "/api/Inform/projectApply";

    /**
     * 项目参与确认列表
     */
    public static final String PROJECTINVITE = "/api/Inform/projectInvite";


    /**
     * 公司申请列表
     */
    public static final String COMPANYAPPLY = "/api/Inform/companyApply";


    /**
     * 项目统筹申请(是否同意)
     */
    public static final String APPLYPASS = "/api/user_operation/applyPass";


    /**
     * 项目参与确认(是否同意)
     */
    public static final String INVITEPASS = "/api/user_operation/invitePass";

    /**
     * 公司申请(是否同意)
     */
    public static final String COMPANYPASS = "/api/user_operation/companyPass";

    /**
     * 设置单聊正在谈的项目
     */
    public static final String SETCHATPROJECT = "/api/rc/setChatProject";
    /**
     * 获取单聊正在谈的项目
     */
    public static final String GETCHATPROJECT = "/api/rc/getChatProject";
    /**
     * 确认合作发送的请求
     */
    public static final String COOPERATION = "/api/rc/cooperation";

    /**
     * 添加关注
     */
    public static final String ADDFOCUS = "/api/show/addFocus";
    /**
     * 收藏 项目
     */
    public static final String PROJECTLIST = "/api/collect/projectList";
    /**
     * 收藏 人员
     */
    public static final String USERLIST = "/api/collect/userList";
    /**
     * 收藏 物品
     */
    public static final String GOODSLIST = "/api/collect/goodsList";
    /**
     * 收藏 课程
     */
    public static final String COURSELIST = "/api/collect/courseList";



}
