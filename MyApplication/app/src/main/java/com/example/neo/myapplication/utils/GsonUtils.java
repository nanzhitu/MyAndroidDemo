package com.example.neo.myapplication.utils;


import com.google.gson.Gson;

/**
 * Created by Neo on 2017/9/5.
 * Gson 工具类
 */

public class GsonUtils {

    private static GsonUtils sInstance;
    private Gson mGson;

    private GsonUtils(){
        mGson = new Gson();
    }

    public static GsonUtils getInstance(){
        if (sInstance==null){
            synchronized (GsonUtils.class){
                if (sInstance == null){
                    sInstance = new GsonUtils();
                }
            }
        }
        return sInstance;
    }

    public Gson getGson() {
        return mGson;
    }
}
