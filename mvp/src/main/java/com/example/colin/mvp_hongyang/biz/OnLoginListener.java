package com.example.colin.mvp_hongyang.biz;

import com.example.colin.mvp_hongyang.bean.User;

/**
 * Created by colin on 16-3-10.
 */
public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
