package com.example.colin.colinbase.network.retrofit4het;



import com.example.colin.colinbase.constant.Params;
import com.example.colin.colinbase.constant.Urls;
import com.example.colin.colinbase.utils.LogUtil;
import com.example.colin.colinbase.utils.MD5;

import java.util.TreeMap;

/**
 * Created by colin on 15-12-18.
 * 请求参数构建类
 */
public class BaseNetwork {
    private String url;
    private boolean sign;
    private boolean accessToken;
    private TreeMap<String, String> params=new TreeMap<>();

    public BaseNetwork(Builder builder) {
        this.url = builder.url;
        this.sign = builder.sign;
        this.accessToken = builder.accessToken;
        this.params = builder.params;
    }

    public static class Builder {
        private String url;
        private boolean sign;
        private boolean accessToken;
        private TreeMap<String, String> params=new TreeMap<>();

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setSign(boolean sign) {
            this.sign = sign;
            return this;
        }

        public Builder setAccessToken(boolean accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder setParams(TreeMap<String, String> params) {
            this.params = params;
            return this;
        }

        public BaseNetwork build() {
            return new BaseNetwork(this);
        }
    }

    protected void completeParams() {
        //这是请求都需要的,不需要参与判断
        params.put(Params.AppSecret.APP_ID, Params.AppSecret.APP_ID_VALUE);
        params.put(Params.TIMESTAMP, String.valueOf(System.currentTimeMillis()));
        //是否需要签名
        if (sign) {
            params.put(Params.AppSecret.SIGN, params2sign(params));
        }
        //是否需要token
        if (accessToken) {
            params.put(Params.Token.ACCESS_TOKEN, AppContext.getInstance().getAuthModel().getAccessToken());
        }
    }
    //这里的HetApi也可以抽出去
//    HetApi hetApi = ServiceFactory.createRetrofitService(HetApi.class);
    //关注业务
    public TreeMap<String,String> commit() {
        completeParams();
        return params;
    }

    private String params2sign(TreeMap<String, String> params) {
        StringBuilder sb = new StringBuilder("POST");
        sb.append(Urls.SERVER_HOST);
        sb.append(url);
        for (String s : params.keySet()) {
            sb.append(s).append("=").append(params.get(s)).append("&");
        }
        sb.append(Params.AppSecret.APP_SECRET);
        LogUtil.i("sign param", sb.toString());
        return MD5.getMD5(sb.toString());
    }


    //        hetApi.login(params).subscribeOn(Schedulers.newThread())//指定观察者代码运行的线程
//                .observeOn(AndroidSchedulers.mainThread())//指定订阅者运行的线程
//                        //对返回的结果过滤
//                .filter(new Func1<Response<AuthModel>, Boolean>() {
//                    @Override
//                    public Boolean call(Response<AuthModel> response) {
//                        int code = response.getCode();
//                        return code == 0;
//                    }
//                })
//                .subscribe(new Action1<Response<AuthModel>>() {
//                    @Override
//                    public void call(Response<AuthModel> response) {
//                        LogUtil.i(response.toString());
//                        LogUtil.i(response.getCode() + "");
//                        LogUtil.i(response.getData().toString());
//                        EventBus.getDefault().post(new LoginEvent("getAuthModelSuccess", response.getData()));
//
//                    }
//                }, new Action1<Throwable>() {
//                    @Override
//                    public void call(Throwable throwable) {
//                        LogUtil.e(throwable.getMessage());
//                    }
//                });
}
