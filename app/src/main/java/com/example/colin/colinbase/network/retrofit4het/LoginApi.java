package com.example.colin.colinbase.network.retrofit4het;


import com.example.colin.colinbase.constant.Urls;
import com.example.colin.colinbase.utils.SecurityUtils;
import com.jiongbull.jlog.JLog;

import java.util.TreeMap;

import retrofit.Callback;
import retrofit.Retrofit;


/**
 * Created by colin on 15-12-23.
 * 关注提交的参数和用哪一个接口
 */
public class LoginApi {
    private static HetApi hetApi = ServiceFactory.createRetrofitService(HetApi.class);
    private static TreeMap<String,String> params=new TreeMap<>();
    public static void login(String account,String psw) {
        params.clear();
        params.put("account", account);
        params.put("password", SecurityUtils.encrypt4login(psw, AppContext.getAppSecret()));
        params=new BaseNetwork.Builder().setSign(true).setUrl(Urls.Login.LOGIN).setParams(params).build().commit();
        hetApi.login(params).clone().enqueue(new Callback<Response<AuthModel>>() {
            @Override
            public void onResponse(retrofit.Response<Response<AuthModel>> response, Retrofit retrofit) {
                JLog.i(response.body().getData().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                JLog.i(t.toString());
            }
        });
    }
}
