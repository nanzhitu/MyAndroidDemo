package com.example.neo.myapplication.utils;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.example.neo.myapplication.base.BaseApplication;


/**
 * Created by Neo on 17/6/13.
 *
 */

public class ToastUtil {

    private static Toast sToast;

    public static void showShort(String message){
        if(BaseApplication.getAppHandler() != null && BaseApplication.getAppContext() != null) {

            BaseApplication.getAppHandler().post(() -> {
                if (sToast == null) {
                    sToast = Toast.makeText(BaseApplication.getAppContext(), message, Toast.LENGTH_SHORT);
                }
                else{
                    sToast.setText(message);
                }
                sToast.show();
            });
        }
    }

    public static void showLong(String message){
        if(BaseApplication.getAppHandler() != null && BaseApplication.getAppContext() != null) {

            BaseApplication.getAppHandler().post(() -> {
                if (sToast == null) {
                    sToast = Toast.makeText(BaseApplication.getAppContext(), message, Toast.LENGTH_LONG);
                }
                else{
                    sToast.setText(message);
                }
                sToast.show();
            });
        }
    }

    public static void showShort(Handler handler,Context context, String message){

        if( handler != null && context != null) {
            handler.post(new Runnable() {
                @Override
                public void run() {
                    if (sToast == null) {
                        sToast = Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_SHORT);
                    }
                    else{
                        sToast.setText(message);
                    }
                    sToast.show();
                }
            });
        }
    }

    public static void showLong(Context context,String message){
        if( context != null) {
            if (sToast == null) {
                sToast = Toast.makeText(context.getApplicationContext(), message, Toast.LENGTH_LONG);
            }
            else{
                sToast.setText(message);
            }
            sToast.show();
        }
    }

}
