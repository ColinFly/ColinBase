package com.example.colin.mvp_sunny.presenter;

import android.content.Intent;
import com.example.colin.mvp_sunny.base.BaseActivity;
import com.example.colin.mvp_sunny.view.LoginView;

/**
 * Created by colin on 16-3-10.
 */
public class LoginAtyPresenter extends BaseActivity<LoginView> {
    @Override
    public Class getResenterClass() {
        return LoginView.class;
    }


}
