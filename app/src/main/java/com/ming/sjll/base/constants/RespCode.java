package com.ming.sjll.base.constants;

/**
 * Created by Nowy on 2016/10/14.
 * 服务的响应码对照表
 */
public interface RespCode {
    /**
     * 本地异常码，表示网络访问失败
     */
    int CODE_NATIVE_NET_ERROR = -1000;//

    /**
     * 未知错误
     */
    int CODE_UNKNOWN = -10096;
    /**
     * 解析错误
     */
    int CODE_PARSE_ERROR = -10010;
    /**
     * 网络错误
     */
    int CODE_NETWORD_ERROR = -10020;
    /**
     * 协议出错
     */
    int CODE_HTTP_ERROR = -10030;



    /**
     * 代码异常
     */
    int CODE_ERROR = -10097;


    /*-------------------------系统-----------------------------*/
    /**
     * 成功
     */
    int CODE_SUCCESS = 1;

    /**
     * 成功
     */
    int WXCODE_SUCCESS = 0;

    /**
     * 验证失败（token过期）
     */
    int CODE_TOKEN_VERIFY_FAIL=403;



}
