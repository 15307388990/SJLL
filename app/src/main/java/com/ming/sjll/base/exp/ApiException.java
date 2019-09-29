package com.ming.sjll.base.exp;


import com.ming.sjll.base.constants.RespErrorAction;

/**
 * @author luoming
 *created at 2019/8/6 3:02 PM
*/

public class ApiException extends Exception {
    private final int code;
    public String msg;
    private Object object;
    public ApiException(Throwable throwable, int code) {
        super(throwable);
        this.code = code;
        this.msg = RespErrorAction.getMsgByCode(code);
    }

    public ApiException(Throwable throwable, int code, Object object) {
        super(throwable);
        this.code = code;
        this.msg = RespErrorAction.getMsgByCode(code);
        this.object = object;
    }

    public int getCode() {
        return code;
    }

    public Object getObject() {
        return object;
    }

    @Override
    public String toString() {
        return "\nCause：\n"+getCause()+"\ncode:"+code+"\nmsg:"+msg;
    }
}
