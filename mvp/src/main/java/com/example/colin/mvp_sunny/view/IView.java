package com.example.colin.mvp_sunny.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by colin on 16-3-10.
 */
public interface IView {
    /**
     * 创建视图
     * @param inflater
     * @param viewGroup
     * @param savedInstance
     */
    void createView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstance);

    /**
     * 实例化控件
     */
    void initWidget();

    /**
     * 获取根布局
     * @return
     */
    View getRootView();

}
