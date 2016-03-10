package com.example.colin.mvp_hongyang.biz;

import com.example.colin.mvp_hongyang.bean.User;

/**
 * Created by colin on 16-3-10.
 * 登录的逻辑业务实现
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String username, final String password, final OnLoginListener loginListener) {
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //登录成功
                if ("123".equals(username) && "123".equals(password)) {
                    User user = new User();
                    user.setUsername("Colin");
                    user.setPassword("123");
                    loginListener.loginSuccess(user);//以往是直接写在了Activity或Manager中
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
