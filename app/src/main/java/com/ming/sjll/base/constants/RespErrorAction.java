package com.ming.sjll.base.constants;

/**
 * Created by Nowy on 2016/10/14.
 */

public class RespErrorAction {
    private static final String MEG_ERROR = "服务器错误";
    public static final String MSG_NETWORK_ERROR ="网络访问失败,请检测网络是否畅通！";


    /**
     * 响应吗是否代表成功
     * @param respCode
     * @return
     */
    public static boolean isSuccess(int respCode){
        switch (respCode){
            case RespCode.WXCODE_SUCCESS:
                return true;
            default:
                return false;
        }
    }



    public static String getMsgByCode(int respCode){
        String msg;
        switch (respCode) {
            case RespCode.CODE_NATIVE_NET_ERROR:
                msg="网络访问失败";
                break;
            case RespCode.CODE_UNKNOWN:
                msg="未知错误";
                break;
            case RespCode.CODE_PARSE_ERROR:
                msg="解析错误";
                break;
            case RespCode.CODE_NETWORD_ERROR:
                msg="网络错误";
                break;
            case RespCode.CODE_HTTP_ERROR:
                msg="协议出错";
                break;
            case RespCode.CODE_ERROR:
                msg = "代码异常，请查看日志";
                break;
            case RespCode.CODE_SUCCESS:
                msg="成功";
                break;
            case RespCode.WXCODE_SUCCESS:
                msg="失败";
                break;
            case RespCode.CODE_TOKEN_VERIFY_FAIL:
                msg="验证失败";
                break;
            default:
                msg="其他异常情况";
                break;
        }
        return msg;
    }

}
