package com.ming.sjll.api;

import android.text.TextUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;

/**
 * 设置全局通用的公共参数
 * @link https://github.com/jkyeo/okhttp-basicparamsinterceptor
 * post请求需要刷新Content-Length的数量
 * MultipartBody拼装需要注意分割线（boundary）问题
 *
 */
public class BasicParamsInterceptor implements Interceptor {

    Map<String, String> queryParamsMap = new HashMap<>();
    Map<String, String> paramsMap = new HashMap<>();
    Map<String, String> headerParamsMap = new HashMap<>();
    List<String> headerLinesList = new ArrayList<>();

    private BasicParamsInterceptor() {

    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();

        // process header params inject
        Headers.Builder headerBuilder = request.headers().newBuilder();
        if (headerParamsMap.size() > 0) {
            Iterator iterator = headerParamsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                headerBuilder.add((String) entry.getKey(), (String) entry.getValue());
            }
        }

        //按行添加请求头
        if (headerLinesList.size() > 0) {
            for (String line: headerLinesList) {
                headerBuilder.add(line);
            }
        }

        // process header params end


        // process queryParams inject whatever it's GET or POST
        if (queryParamsMap.size() > 0) {
            request = injectParamsIntoUrl(request.url().newBuilder(), requestBuilder, queryParamsMap);
        }

        // process post body inject
        if (paramsMap != null && paramsMap.size() > 0
                && request != null && request.method().equals("POST")) {
            if (request.body() instanceof FormBody) {
                FormBody.Builder newFormBodyBuilder = new FormBody.Builder();
                if (paramsMap.size() > 0) {
                    Iterator iterator = paramsMap.entrySet().iterator();
                    while (iterator.hasNext()) {
                        Map.Entry entry = (Map.Entry) iterator.next();
                        newFormBodyBuilder.add((String) entry.getKey(), (String) entry.getValue());
                    }
                }
                FormBody oldFormBody = (FormBody) request.body();
                int paramSize = oldFormBody == null ? 0 : oldFormBody.size();
                if (paramSize > 0) {
                    for (int i=0;i<paramSize;i++) {
                        newFormBodyBuilder.add(oldFormBody.name(i), oldFormBody.value(i));
                    }
                }

                FormBody newFormBody = newFormBodyBuilder.build();
                long newContentLength = newFormBody.contentLength();
                requestBuilder.post(newFormBody);


                updateHeader(headerBuilder,requestBuilder,newContentLength);
                request = requestBuilder.build();

            } else if (request.body() instanceof MultipartBody) {
                MultipartBody multipartBody = ((MultipartBody)request.body());
                List<MultipartBody.Part> oldParts = null ;

                String boundary = null;
                if(multipartBody != null){
                    boundary = multipartBody.boundary();
                    oldParts =  multipartBody.parts();
                }

                /**
                 * 保证分割线（boundary）与请求头相同
                 */
                MultipartBody.Builder multipartBuilder;
                if(boundary != null){
                    multipartBuilder = new MultipartBody.Builder(boundary).setType(MultipartBody.FORM);
                }else{
                    multipartBuilder = new MultipartBody.Builder().setType(MultipartBody.FORM);
                }

                Iterator iterator = paramsMap.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    multipartBuilder.addFormDataPart((String) entry.getKey(), (String) entry.getValue());
                }



                if (oldParts != null && oldParts.size() > 0) {
                    for (MultipartBody.Part part : oldParts) {
                        multipartBuilder.addPart(part);
                    }
                }
                MultipartBody newMultipartBody = multipartBuilder.build();
                long newContentLength = newMultipartBody.contentLength();
                requestBuilder.post(newMultipartBody);
                updateHeader(headerBuilder,requestBuilder,newContentLength);
                request = requestBuilder.build();
            }

        }else{
            request = requestBuilder.build();
        }

        requestBuilder.headers(headerBuilder.build());

        return chain.proceed(request);
    }

    private void updateHeader(Headers.Builder headerBuilder, Request.Builder requestBuilder, long newContentLength){
        headerBuilder.set("Content-Length", String.valueOf(newContentLength));
        requestBuilder.headers(headerBuilder.build());
    }

    private boolean canInjectIntoBody(Request request) {
        if (request == null) {
            return false;
        }
        if (!TextUtils.equals(request.method(), "POST")) {
            return false;
        }
        RequestBody body = request.body();
        if (body == null) {
            return false;
        }
        MediaType mediaType = body.contentType();
        if (mediaType == null) {
            return false;
        }
        if (!TextUtils.equals(mediaType.subtype(), "x-www-form-urlencoded")) {
            return false;
        }
        return true;
    }

    // func to inject params into url
    private Request injectParamsIntoUrl(HttpUrl.Builder httpUrlBuilder, Request.Builder requestBuilder, Map<String, String> paramsMap) {
        if (paramsMap.size() > 0) {
            Iterator iterator = paramsMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                httpUrlBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
            requestBuilder.url(httpUrlBuilder.build());
            return requestBuilder.build();
        }

        return null;
    }

    private static String bodyToString(final RequestBody request){
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if(copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        }
        catch (final IOException e) {
            return "did not work";
        }
    }

    public static class Builder {

        BasicParamsInterceptor interceptor;

        public Builder() {
            interceptor = new BasicParamsInterceptor();
        }

        public Builder addParam(String key, String value) {
            interceptor.paramsMap.put(key, value);
            return this;
        }

        public Builder addParamsMap(Map<String, String> paramsMap) {
            interceptor.paramsMap.putAll(paramsMap);
            return this;
        }

        public Builder addHeaderParam(String key, String value) {
            interceptor.headerParamsMap.put(key, value);
            return this;
        }

        public Builder addHeaderParamsMap(Map<String, String> headerParamsMap) {
            interceptor.headerParamsMap.putAll(headerParamsMap);
            return this;
        }

        public Builder addHeaderLine(String headerLine) {
            int index = headerLine.indexOf(":");
            if (index == -1) {
                throw new IllegalArgumentException("Unexpected header: " + headerLine);
            }
            interceptor.headerLinesList.add(headerLine);
            return this;
        }

        public Builder addHeaderLinesList(List<String> headerLinesList) {
            for (String headerLine: headerLinesList) {
                int index = headerLine.indexOf(":");
                if (index == -1) {
                    throw new IllegalArgumentException("Unexpected header: " + headerLine);
                }
                interceptor.headerLinesList.add(headerLine);
            }
            return this;
        }

        public Builder addQueryParam(String key, String value) {
            interceptor.queryParamsMap.put(key, value);
            return this;
        }

        public Builder addQueryParamsMap(Map<String, String> queryParamsMap) {
            interceptor.queryParamsMap.putAll(queryParamsMap);
            return this;
        }

        public BasicParamsInterceptor build() {
            return interceptor;
        }

    }
}
