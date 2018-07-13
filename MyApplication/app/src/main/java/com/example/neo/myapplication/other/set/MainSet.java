package com.example.neo.myapplication.other.set;

import android.content.Context;

import com.example.neo.myapplication.test.ITest;
import com.example.neo.myapplication.utils.LogUtils;

/**
 * Created by Neo on 2018/7/13.
 */

public class MainSet extends ITest {

    private static final String TAG = "MainSet";
    private static MainSet sMainSet;
    private MainSet(){

    }

    public static MainSet getInstance(){
        if(sMainSet == null){
            synchronized (MainSet.class){
                if(sMainSet == null){
                    sMainSet = new MainSet();
                }
            }
        }
        return sMainSet;
    }

    @Override
    public void init(Context context){

    }

    @Override
    public void init() {
        MyMap.getInstance().init();
        MySet.getInstance().init();
    }

    @Override
    public void test(){
        LogUtils.d(TAG," MyMap MySet");
        MyMap.getInstance().test();
        MySet.getInstance().test();
    }

}
