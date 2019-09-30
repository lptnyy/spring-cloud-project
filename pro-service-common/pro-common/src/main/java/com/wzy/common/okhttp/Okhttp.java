package com.wzy.common.okhttp;

import okhttp3.*;
import java.io.IOException;
import java.util.Map;

/**
 * 封装 http请求
 */
public class Okhttp {

    // 请求主类
    OkHttpClient client = new OkHttpClient();

    static Okhttp okhttp;
    public static Okhttp getInstance() {
        if (okhttp == null) {
            synchronized (Okhttp.class) {
                if (okhttp == null) {
                    okhttp = new Okhttp();
                }
            }
        }
        return okhttp;
    }

    /**
     * get 请求
     * @param headers
     * @param url
     * @return
     */
    public String get(Map<String,String> headers, String url) throws IOException {
        Headers.Builder okhttpBuilder = new Headers.Builder();
        if (headers != null) {
            headers.forEach((k, v) -> {
                okhttpBuilder.add(k, v);
            });
        }
        Request request = new Request.Builder()
                .headers(okhttpBuilder.build())
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    /**
     * post 请求
     * @param headers
     * @param url
     * @return
     */
    public String post(Map<String,String> headers, String url, String json) throws IOException {
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        Headers.Builder okhttpBuilder = new Headers.Builder();
        if (headers != null) {
            headers.forEach((k, v) -> {
                okhttpBuilder.add(k, v);
            });
        }
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .headers(okhttpBuilder.build())
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}
