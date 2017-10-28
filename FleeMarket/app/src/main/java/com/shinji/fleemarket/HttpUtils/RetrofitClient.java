package com.shinji.fleemarket.HttpUtils;

import com.google.gson.Gson;
import com.shinji.fleemarket.HttpUtils.Converter.AvatarConverter;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;


/**
 * Created by LiCola on  2016/04/16  0:08
 */
public class RetrofitClient {

    //所有的联网地址 统一成https
//    private static String mBaseUrl = "http://bucssa.net/BucssaApi/V1.0/";
    private static String mBaseUrl = "http://bucssa.net/API/v1/";

    private static Gson gson = new Gson();

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    public static Retrofit.Builder builder = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            //增加返回值为String的支持
            .addConverterFactory(ScalarsConverterFactory.create())
            //增加返回值为jason的支持
            .addConverterFactory(AvatarConverter.create(gson));

    public static <S> S createService(Class<S> serviceClass, String baseUrl) {
        Retrofit retrofit = builder
                .baseUrl(baseUrl)
                .client(OkHttpHelper.addLogClient(httpClient).build())
                .build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder
                .baseUrl(mBaseUrl)
                .client(OkHttpHelper.addLogClient(httpClient).build())
                .build();
        return retrofit.create(serviceClass);
    }

    public static <S> S createService(Class<S> serviceClass, OnProgressResponseListener listener) {
        Retrofit retrofit = builder
                .client(OkHttpHelper.addProgressClient(httpClient, listener).build())
                .build();
        return retrofit.create(serviceClass);
    }
}
