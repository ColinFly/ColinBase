package com.example.colin.mvp_hongyang.biz;

/**
 * Created by colin on 16-3-10.
 * 登录的逻辑业务接口
 */
public interface IUserBiz {
    void login(String username, String password, OnLoginListener loginListener);
}
