package com.example.neo.myapplication.test;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.example.neo.myapplication.utils.LogUtils;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Neo on 2019/3/15.
 */

public class TestExecutors extends ITest {

    private static final String TAG = "TestExecutors";
    @Override
    public void init(Context context) {

    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        newCachedThreadPool();

        sleep(5000);

        newFixedThreadPool();

        sleep(5000);

        newScheduledThreadPool();

        sleep(5000);

        new Thread(new Runnable() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void run() {
                newWorkStealingPool();
            }
        }).start();


    }

    private void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void newCachedThreadPool(){
        ExecutorService m = Executors.newCachedThreadPool();

        for(int i=1;i<=10;i++){
            final int count=i;

            m.submit(new Runnable(){
                @Override
                public void run() {
                    LogUtils.d(TAG,"newCachedThreadPool , 线程："+Thread.currentThread()+"负责了"+count+"次任务");
                }

            });
            //下面这行代码注释的话，线程池会新建10个线程，不注释的话，因为会复用老线程，不会产生10个线程
//			Thread.sleep(1);
        }
    }

    private void newFixedThreadPool(){
        ExecutorService m=Executors.newFixedThreadPool(4);

        for(int i=1;i<=10;i++){
            final int count=i;

            m.submit(new Runnable(){
                @Override
                public void run() {
                    LogUtils.d(TAG,"newFixedThreadPool, 线程："+Thread.currentThread()+"负责了"+count+"次任务");
                }

            });
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void newScheduledThreadPool(){
        // 指定大小为4
        ScheduledExecutorService m = Executors.newScheduledThreadPool(4);

        m.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Date now = new Date();
                LogUtils.d(TAG,"newScheduledThreadPool,线程" + Thread.currentThread() + "报时：" + now);
            }

        }, 1, 1, TimeUnit.SECONDS); // 延迟1s秒执行，每隔1s执行一次
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void newWorkStealingPool(){
        // 设置并行级别为2，即默认每时每刻只有2个线程同时执行
        ExecutorService m = Executors.newWorkStealingPool(2);

        for (int i = 1; i <= 10; i++) {
            final int count=i;
            m.submit(new Runnable() {
                @Override
                public void run() {
                    Date now=new Date();
                    LogUtils.d(TAG,"newWorkStealingPool,线程" + Thread.currentThread() + "完成任务："
                            + count+"   时间为："+	now.getSeconds());
                    try {
                        Thread.sleep(1000);//此任务耗时1s
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            });

        }
        while(true){
            //主线程陷入死循环，来观察结果，否则是看不到结果的
        }
    }
}
