package com.example.neo.myapplication.utils;

import android.Manifest;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by neo on 2018/4/16.
 */

public final class PermissionUtils {

    private PermissionUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void needPermission(Activity activity, int requestCode, String[] permissions){
        List<String> denyPermissions = findDeniedPermissions(activity,permissions);
        if(denyPermissions.size() > 0){
            requestPermissions(activity,denyPermissions.toArray(new String[denyPermissions.size()]),requestCode);
        }
    }
    public static boolean checkPermission(Context context, String permission){
        return ContextCompat.checkSelfPermission(context,permission)== PackageManager.PERMISSION_DENIED;
    }

    public static void requestPermissions(Activity activity, String[] permission, int requestcode){
        ActivityCompat.requestPermissions(activity,permission, requestcode);
    }

    public static List<String> findDeniedPermissions(Activity activity, String... permission)
    {
        List<String> denyPermissions = new ArrayList<>();
        for (String value : permission)
        {
            if (ContextCompat.checkSelfPermission(activity,value) != PackageManager.PERMISSION_GRANTED)
            {
                denyPermissions.add(value);
            }
        }
        return denyPermissions;
    }


}
