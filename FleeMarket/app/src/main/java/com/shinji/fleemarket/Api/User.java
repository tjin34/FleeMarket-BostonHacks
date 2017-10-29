package com.shinji.fleemarket.Api;

import com.shinji.fleemarket.Bean.BaseEntity;
import com.shinji.fleemarket.Bean.UserInfo;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by KimuraShin on 17/10/29.
 */

public interface User {

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("User/login.php")
    Observable<BaseEntity> login(@Body RequestBody json);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("User/register.php")
    Observable<BaseEntity> register(@Body RequestBody json);


    @GET("User/getUserInfo.php")
    Observable<BaseEntity<UserInfo>> getMyInfos(@Query("uid") int uid, @Query("token") String token);
}
