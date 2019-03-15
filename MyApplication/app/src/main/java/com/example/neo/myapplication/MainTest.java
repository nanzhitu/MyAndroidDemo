package com.example.neo.myapplication;

import android.content.Context;

import com.example.neo.myapplication.other.set.MainSet;
import com.example.neo.myapplication.test.ITest;
import com.example.neo.myapplication.test.TestExecutors;
import com.example.neo.myapplication.test.TestJobService;
import com.example.neo.myapplication.test.TestSemaphore;
import com.example.neo.myapplication.utils.LogUtils;

/**
 * Created by Neo on 2018/7/13.
 */

public class MainTest extends ITest {

    private static final String TAG = "MainTest";
    private static MainTest sMainTest;
    private MainTest(){

    }

    public static MainTest getInstance(){
        if(sMainTest == null){
            synchronized (MainTest.class){
                if(sMainTest == null){
                    sMainTest = new MainTest();
                }
            }
        }
        return sMainTest;
    }

    @Override
    public void init(Context context) {
        TestJobService.getInstance().init(context);
        TestSemaphore.getInstance().init();
        MainSet.getInstance().init();
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        LogUtils.d(TAG," test");
        TestJobService.getInstance().test();
        TestSemaphore.getInstance().test();
        new TestExecutors().test();
        MainSet.getInstance().test();
    }

}
