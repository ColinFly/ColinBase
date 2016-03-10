package com.example.colin.mvp_sunny.view;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by colin on 16-3-10.
 */
public abstract class AbsView implements IView,View.OnClickListener {
    private SparseArray<View> mBindViews = new SparseArray<>();//存放view的集合
    public Context context;
    private View rootView;

    @Override
    public void createView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstance) {
        rootView = inflater.inflate(getLayoutId(), viewGroup, false);
        context = rootView.getContext();
    }

    @Override
    public void initWidget() {

    }

    @Override
    public View getRootView() {
        return rootView;
    }

    public void setClickView(View view) {
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    // 获取布局文件id
    public abstract int getLayoutId();

    // 把子控件用一个集合存起来
    public <T extends View> T bindView(int viewId) {
        T t= (T) mBindViews.get(viewId);
        if (t == null) {
            //如果集合里找不到就从rootView中找,并存入集合
            t = (T) rootView.findViewById(viewId);
            mBindViews.put(viewId,t);
        }
        return t;
    }


    public <T extends View> T getViewById(int viewId) {
        return (T) rootView.findViewById(viewId);
    }
}
