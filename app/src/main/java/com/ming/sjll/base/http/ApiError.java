package com.ming.sjll.base.http;

/**
 * Api错误
 *
 * @author linjie
 * @since 2017/8/16 下午2:43
 */
public class ApiError {
    public static final String NET_ERROR_MSG = "网络请求失败，请稍后重试再试";
    public static final int LOGIN_FAILED = -10000;  // 未登录
    public static final int CONNECT_ERROR = -20000;
    public static final int PARSE_ERROR = -30000;
    public static final int UNKNOWN = -40000;
}
