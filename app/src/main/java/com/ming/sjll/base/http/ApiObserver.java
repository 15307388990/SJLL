package com.ming.sjll.base.http;

import android.util.Log;

import com.google.gson.stream.MalformedJsonException;
import com.ming.sjll.BuildConfig;
import com.ming.sjll.base.constants.RespErrorAction;
import com.ming.sjll.base.exp.ApiException;
import com.ming.sjll.base.exp.NetResultException;
import com.ming.sjll.base.widget.ToastShow;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Locale;

import androidx.annotation.NonNull;
import io.reactivex.observers.DisposableObserver;
import retrofit2.HttpException;

/**
 * Api返回结果
 *
 * @author linjie
 * @date 2017/10/18
 */
public abstract class ApiObserver<T> extends DisposableObserver<T> {
    private static final String TAG = ApiObserver.class.getSimpleName();

    @Override
    public void onNext(@NonNull T t) {
        onSuccess(t);
    }

    @Override
    public void onError(@NonNull Throwable e) {
        Log.e(TAG, e.toString());

        if (e instanceof SocketTimeoutException || e instanceof ConnectException ||
                e instanceof UnknownHostException || e instanceof HttpException) {
            onFailure(ApiError.CONNECT_ERROR, ApiError.NET_ERROR_MSG);
        } else if (e instanceof MalformedJsonException) {
            onFailure(ApiError.PARSE_ERROR, ApiError.NET_ERROR_MSG);
        } else if (e instanceof NetResultException) {   //服务器返回的错误
            Log.d("NetResultException", "NetResultException");
            NetResultException resultException = (NetResultException) e;
            ApiException ex = new ApiException(resultException, resultException.errCode, resultException.getObject());
            ex.msg = resultException.message;
            onError(ex);
        } else {
            onFailure(ApiError.UNKNOWN, ApiError.NET_ERROR_MSG);
        }
    }


    @Override
    public void onComplete() {

    }

    public abstract void onSuccess(T data);

    public abstract void onFailure(int code, String msg);

    public void onError(ApiException e) {
        int respCode = e.getCode();
        String msg = e.msg;
        if (BuildConfig.DEBUG)
            msg = String.format(Locale.CHINA, "%1$s(%2$d)", msg, respCode);
        /**
         * 此处data为请求返回的json数据（字符串形式）
         */
        Object data = e.getObject();

        if (RespErrorAction.isLoginError(respCode)) {//登录问题
            onLoginExpired(respCode, msg, data);
        } else {
            onFailure(respCode, msg);//数据异常
        }
    }

    public void onLoginExpired(int code, String msg, Object data) {
        ToastShow.s("登录过期或者账号在别的设备登录，请重新登录");
        //ActLogin.start(LianwoApplication.getInstance());
    }
}
