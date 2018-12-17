package com.example.neo.myapplication.base;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;

/**
 * Created by Neo on 2018/1/3
 */

public class BaseApplication extends Application {

    private static final String TAG = BaseApplication.class.getSimpleName();
    private LocalBroadcastManager mBindBroadcastManager;
    private static BaseApplication sApplication;
    private static Handler sHandler;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
        sHandler = new Handler();

    }

    public static BaseApplication getAppContext() {
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