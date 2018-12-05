package com.example.neo.myapplication.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import com.example.neo.myapplication.utils.callback.MyActivityLifecycleCallbacks;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public final class Utils {

    @SuppressLint("StaticFieldLeak")
    private static Application sApplication;

    private static Context mContext;
    private static Handler sHandler;

    private static WeakReference<Activity> sTopActivityWeakRef;
    private static List<Activity> sActivityList = new LinkedList<>();
    private static List<Activity> sResumeActivity=new ArrayList<>();

    private static Application.ActivityLifecycleCallbacks mCallbacks = new MyActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            sActivityList.add(0,activity);
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            setTopActivityWeakRef(activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            setTopActivityWeakRef(activity);
            if (!sResumeActivity.contains(activity)) {
                sResumeActivity.add(activity);
            }
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {
            sResumeActivity.remove(activity);
        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            sActivityList.remove(activity);
        }

        @Override
        public Activity current() {
            return sActivityList.size()>0 ? sActivityList.get(0): null;
        }

        @Override
        public int count() {
            return sActivityList.size();
        }

        @Override
        public boolean isFront() {
            return sResumeActivity.size() > 0;
        }
    };

    private Utils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    /**
     * 初始化工具类
     *
     * @param app 应用
     */
    public static void init(@NonNull final Application app) {
        Utils.sApplication = app;
        app.registerActivityLifecycleCallbacks(mCallbacks);
        Utils.mContext = app;
        sHandler = new Handler(Looper.getMainLooper());
    }

    /**
     * 去初始化工具类
     *
     */
    public static void unInit() {
        sHandler = null;
        mContext = null;
    }

    /**
     * 获取 Application
     *
     * @return Application
     */
    public static Application getApp() {
        if (sApplication != null) return sApplication;
        throw new NullPointerException("u should init first");
    }

    /**
     * 获取 Application
     *
     * @return Context
     */
    public static Context getAppContext() {
        if (mContext != null) return mContext;
        throw new NullPointerException("u should init first");
    }

    /**
     * 获取 Handler
     *
     * @return Handler
     */
    public static Handler getAppHandler(){
        if (sHandler != null) return sHandler;
        throw new NullPointerException("u should init first");
    }

    public static void sendBroadCast(String action){
        sendBroadCast(new Intent(action));
    }

    public static void sendBroadCast(Intent intent){
        mContext.sendBroadcast(intent);
    }

    private static void setTopActivityWeakRef(Activity activity) {
        if (sTopActivityWeakRef == null || !activity.equals(sTopActivityWeakRef.get())) {
            sTopActivityWeakRef = new WeakReference<>(activity);
        }
    }
}
