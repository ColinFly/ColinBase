package com.example.colin.mvp_sunny.presenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.colin.mvp_sunny.view.IView;

/**
 * Created by colin on 16-3-10.
 */
public  abstract class ActivityPresenter<T extends IView> extends AppCompatActivity {
    private T mView;
    private Context context;

//    由子类去实现它，通过newInstance来获取实例化对象
    public abstract Class<T> getResenterClass();


    public ActivityPresenter() {
        try {
            mView = getResenterClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        if (mView != null) {
            mView.createView(getLayoutInflater(),null,savedInstanceState);
        }
        setContentView(mView.getRootView());
        //初始化布局子控件
        mView.initWidget();
    }
}
