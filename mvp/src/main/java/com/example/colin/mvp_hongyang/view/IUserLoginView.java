package com.example.colin.mvp_hongyang.view;

/**
 * Created by colin on 16-3-10.
 * 将view上进行的取和放进行了抽象
 */
public interface IUserLoginView {

    String getUserName();

    String getPassword();

    void showLoading();

    void hideLoading();

    void showFailedError();

}
