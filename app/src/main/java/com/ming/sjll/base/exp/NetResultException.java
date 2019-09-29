package com.ming.sjll.base.exp;

public class NetResultException extends RuntimeException {

    public int errCode = 0;
    public String message;
    private Object data;
    public NetResultException(int errCode, String msg) {
        super(msg);
        this.errCode = errCode;
        this.message = msg;
    }

    public NetResultException(int errCode, String msg, Object data) {
        super(msg);
        this.errCode = errCode;
        this.message = msg;
        this.data = data;
    }


    public Object getObject() {
        return data;
    }

    public int getErrCode() {
        return errCode;
    }
}