package com.example.neo.myapplication.test;

import android.content.Context;

import com.example.neo.myapplication.utils.LogUtils;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by Neo on 2019/3/15.
 */

public class TestSemaphore extends ITest {

    private static final String TAG = "TestSemaphore";
    private Semaphore mSemaphore;
    private Random rnd = new Random();
    private  ExecutorService mExecutorService;


    private static TestSemaphore sTestSemaphore;
    private TestSemaphore(){

    }

    public static TestSemaphore getInstance(){
        if(sTestSemaphore == null){
            synchronized (TestSemaphore.class){
                if(sTestSemaphore == null){
                    sTestSemaphore = new TestSemaphore();
                }
            }
        }
        return sTestSemaphore;
    }

    @Override
    public void init(Context context) {

    }

    @Override
    public void init() {
        mSemaphore = new Semaphore(3,true); //公平策略
        mExecutorService = Executors.newCachedThreadPool();

    }

    @Override
    public void test() {
        mExecutorService.submit(new Task("a"));
        mExecutorService.submit(new Task("b"));
        mExecutorService.submit(new Task("c"));
        mExecutorService.submit(new Task("d"));
        mExecutorService.submit(new Task("e"));
        mExecutorService.submit(new Task("f"));
        mExecutorService.shutdown();
    }

    private class Task implements Runnable{
        private String id;
        Task(String id){
            this.id = id;
        }

        public void run(){
            try {
                mSemaphore.acquire();
                //smp.acquire(int permits);//使用有参数方法可以使用permits个许可
                LogUtils.d(TAG,"Thread " + id + " is working");
                //System.out.println("在等待的线程数目："+ smp.getQueueLength());
                work();
                LogUtils.d(TAG,"Thread " + id + " is over");
            } catch (InterruptedException e) {
            }
            finally
            {
                mSemaphore.release();
            }
        }

        public void work() {//假装在工作，实际在睡觉
            int worktime = rnd.nextInt(1000);
            LogUtils.d(TAG,"Thread " + id + " worktime  is "+ worktime);
            try {
                Thread.sleep(worktime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
