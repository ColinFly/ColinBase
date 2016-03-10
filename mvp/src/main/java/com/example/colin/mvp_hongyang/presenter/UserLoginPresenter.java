package com.example.colin.mvp_hongyang.presenter;

import android.os.Handler;

import com.example.colin.mvp_hongyang.bean.User;
import com.example.colin.mvp_hongyang.biz.IUserBiz;
import com.example.colin.mvp_hongyang.biz.OnLoginListener;
import com.example.colin.mvp_hongyang.biz.UserBiz;
import com.example.colin.mvp_hongyang.view.IUserLoginView;

/**
 * Created by colin on 16-3-10.
 * 这个类负责指挥view和业务
 */
public class UserLoginPresenter {
    private IUserBiz userBiz;
    private IUserLoginView userLoginView;
    private Handler mHandler=new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {
        this.userLoginView = userLoginView;
        userBiz=new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        userBiz.login(userLoginView.getUserName(), userLoginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {
                //需要到UI线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                //需要到UI线程
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.hideLoading();
                        userLoginView.showFailedError();
                    }
                });

            }
        });
    }


}
