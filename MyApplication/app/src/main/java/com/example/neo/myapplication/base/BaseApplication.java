package com.example.neo.myapplication.base;


import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.LocalBroadcastManager;

import com.example.neo.myapplication.utils.LogUtils;


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
        //Utils.init(this);
        registerActivityLifecycleCallbacks(mCallbacks);
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


    private ActivityLifecycleCallbacks mCallbacks = new ActivityLifecycleCallbacks() {

        @Override
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            LogUtils.d(activity.getLocalClassName(), "onActivityCreated(), savedInstanceState = [" + savedInstanceState + "]");
        }

        @Override
        public void onActivityStarted(Activity activity) {
            LogUtils.d(activity.getLocalClassName(), "onActivityStarted()");
        }

        @Override
        public void onActivityResumed(Activity activity) {
            LogUtils.d(activity.getLocalClassName(), "onActivityResumed() ");
        }

        @Override
        public void onActivityPaused(Activity activity) {
            LogUtils.d(activity.getLocalClassName(), "onActivityPaused() ");
        }

        @Override
        public void onActivityStopped(Activity activity) {
            LogUtils.d(activity.getLocalClassName(), "onActivityStopped() ");
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            LogUtils.d(activity.getLocalClassName(), "onActivitySaveInstanceState(), outState = [" + outState + "]");
        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            LogUtils.d(activity.getLocalClassName(), "onActivityDestroyed() ");
        }
    };

}