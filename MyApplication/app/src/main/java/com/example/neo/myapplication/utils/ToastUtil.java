package com.example.neo.myapplication.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.neo.myapplication.base.BaseApplication;


/**
 * Created by wing on 17/6/13.
 *
 */

public class ToastUtil {

    public static void showShort(String message){
        BaseApplication.getAppHandler().post(() -> Toast.makeText(BaseApplication.getAppContext(), message, Toast.LENGTH_SHORT).show());
    }

    public static void longShort(String message){
        BaseApplication.getAppHandler().post(() -> Toast.makeText(BaseApplication.getAppContext(), message, Toast.LENGTH_LONG).show());
    }

}
