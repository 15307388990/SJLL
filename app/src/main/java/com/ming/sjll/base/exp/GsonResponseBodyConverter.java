package com.ming.sjll.base.exp;

import com.google.gson.Gson;
import com.ming.sjll.base.bean.BaseBean;
import com.ming.sjll.base.constants.RespCode;
import com.ming.sjll.base.constants.RespErrorAction;
import com.ming.sjll.base.utils.TextUtil;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;

class GsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    public static final String TAG = GsonResponseBodyConverter.class.getSimpleName();
    private final Gson gson;
    private final Type type;

    GsonResponseBodyConverter(Gson gson, Type type) {
        this.gson = gson;
        this.type = type;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        try {
            String response = value.string();
            BaseBean resultResponse = gson.fromJson(response, BaseBean.class);

            if (RespErrorAction.isSuccess(resultResponse.getCode())){ //成功
                try {
                    return gson.fromJson(response, type);
                }catch (Exception e){
                    e.printStackTrace();
                    Logger.t(TAG).e("Converter json Error:"+ e.getMessage());
                    throw new NetResultException(RespCode.CODE_PARSE_ERROR,
                            RespErrorAction.getMsgByCode(RespCode.CODE_PARSE_ERROR));
                }

            }else {
                throw new NetResultException (resultResponse.getCode(),
                        (TextUtil.isEmpty(resultResponse.getMsg())&&TextUtil.isEmpty(resultResponse.getMessage()))?
                                RespErrorAction.getMsgByCode(resultResponse.getCode())
                                : (TextUtil.isEmpty(resultResponse.getMessage())?resultResponse.getMsg():resultResponse.getMessage()),response);
            }
        } finally {
        }
    }

    private void printInfo(String response, int respCode, String respContent, Object data) {
        StringBuilder sb = new StringBuilder();
        sb.append("Result=" + response);
        sb.append("\n");
        sb.append("respCode=" + respCode);
        sb.append("\n");
        sb.append("respContent=" + respContent);
        sb.append("\n");
        sb.append("data=" + data);
        Logger.t(TAG).d(sb.toString());
    }
}
