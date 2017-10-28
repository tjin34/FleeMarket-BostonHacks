package com.shinji.fleemarket.HttpUtils;

import com.shinji.fleemarket.Utils.Logger;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by LiCola on  2016/05/23  22:09
 */

public class OkHttpHelper {

    private static ProgressBean progressBean = new ProgressBean();

    private static ProgressHandler mProgressHandler;

    public static OkHttpClient.Builder addLogClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        builder.addInterceptor(logging);
        return builder;
    }

    public static OkHttpClient.Builder addProgressClient(OkHttpClient.Builder builder, final OnProgressResponseListener listener) {

        builder.addNetworkInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Logger.d("start intercept");
                Response originalResponse = chain.proceed(chain.request());
                return originalResponse.newBuilder().body(
                        new ProgressResponseBody(originalResponse.body(), listener))
                        .build();
            }
        });
        return builder;
    }
}
