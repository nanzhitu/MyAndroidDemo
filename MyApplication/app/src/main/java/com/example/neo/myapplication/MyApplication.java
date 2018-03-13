package com.example.neo.myapplication;


import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.example.neo.myapplication.base.BaseApplication;
import com.example.neo.myapplication.utils.LogUtils;
import com.example.neo.myapplication.utils.Utils;
import com.squareup.leakcanary.LeakCanary;


/**
 * Created by Neo on 2018/1/3
 */

public class MyApplication extends BaseApplication {

    private static final String TAG = MyApplication.class.getSimpleName();
    private LocalBroadcastManager mBindBroadcastManager;
    private static MyApplication sApplication;
    private static Handler sHandler;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {

        LogUtils.setDebugLevel(LogUtils.V);

        super.onCreate();
        sApplication = this;
        sHandler = new Handler();
        Utils.init(this);
        initLeakCanary();
        LogUtils.setDebugLevel(LogUtils.V);
    }

    private void initLeakCanary() {
        // 内存泄露检查工具
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }

    public static MyApplication getAppContext() {
        return sApplication;
    }
    public static MyApplication getInstance(){
        return sApplication;
    }
    public static Handler getAppHandler(){
        return sHandler;
    }


    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            switch (action) {
            }
        }
    };

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

}