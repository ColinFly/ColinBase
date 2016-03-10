package com.example.colin.colinbase.base;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import de.greenrobot.event.EventBus;

/**
 * Created by colin on 16-3-10.
 */
public  class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    public Context mContext;
    public Resources mResources;
    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        EventBus.getDefault().register(this);
        ButterKnife.inject(this);
        mContext = this;
        mResources = getResources();
    }
    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
    public void onEventMainThread(BaseEvent event) {
    }

    protected void startActivity(Class<? extends BaseActivity> activity) {
        startActivity(new Intent(this, activity));
    }

    protected void startActivity(Class<? extends BaseActivity> activity, int flag) {
        Intent intent=new Intent(this,activity);
        intent.addFlags(flag);
        startActivity(intent);
    }
    protected void startActivity(Class<? extends BaseActivity> activity,Bundle bundle) {
        Intent intent=new Intent(this,activity);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
