package com.example.colin.colinbase.network.retrofit4het;


import com.example.colin.colinbase.constant.Urls;

import java.util.TreeMap;

import retrofit.Call;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.QueryMap;


/**
 * Created by colin on 15-12-18.
 * 请求接口包含的信息:
 * 1.url
 * 2.返回对象
 * 3.所需参数
 */
public interface HetApi {

    //登录,获取AuthModel
    @FormUrlEncoded
    @POST(Urls.Login.LOGIN)
    Call<Response<AuthModel>> login(@FieldMap TreeMap<String, String> params);

    //获取用户信息
    @GET(Urls.User.GET)
    Call<Response<UserModel>> getUser(@QueryMap TreeMap<String, String> params);

}
