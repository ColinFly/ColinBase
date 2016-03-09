package com.example.colin.colinbase.network.retrofit4het;

import android.app.Application;


import com.example.colin.colinbase.BuildConfig;
import com.example.colin.colinbase.constant.Params;
import com.jiongbull.jlog.JLog;
import com.jiongbull.jlog.constant.LogLevel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by colin on 15-12-22.
 */
public class HetContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化app的Context/appId/appSecret
        AppContext.getInstance().init(getApplicationContext(), Params.AppSecret.APP_ID_VALUE,Params.AppSecret.APP_SECRET);
        //日志工具
        List<LogLevel> logLevels = new ArrayList<>();
        logLevels.add(LogLevel.ERROR);
        logLevels.add(LogLevel.JSON);

        JLog.init(this)
                .setDebug(BuildConfig.DEBUG)//日志会输出到控制台
                .setLogLevelsForFile(logLevels)//决定了哪些级别的日志可以输出到文件中
                .writeToFile(true);//日志开关，如果是true，日志会输出到文件中，默认是false

    }
}
