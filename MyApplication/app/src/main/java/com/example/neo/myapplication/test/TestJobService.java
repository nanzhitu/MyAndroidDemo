package com.example.neo.myapplication.test;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;

import com.example.neo.myapplication.service.MyJobService;
import com.example.neo.myapplication.utils.LogUtils;

/**
 * Created by neo on 2018/7/13.
 */

public class TestJobService extends ITest{

    private static final String TAG = "TestJobService";

    private Context mContext;
    private JobScheduler mScheduler;
    private static TestJobService sTestJobService;
    private TestJobService(){

    }

    public static TestJobService getInstance(){
        if(sTestJobService == null){
            synchronized (TestJobService.class){
                if(sTestJobService == null){
                    sTestJobService = new TestJobService();
                }
            }
        }
        return sTestJobService;
    }

    @Override
    public void init(Context context){
       this.mContext = context;
    }

    @Override
    public void init() {

    }

    @Override
    public void test() {
        LogUtils.d(TAG," delayTime");
        //network();
        delayTime();
    }


    private void network(){
        if(mScheduler == null) {
            mScheduler = (JobScheduler) mContext.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            JobInfo jobInfo = new JobInfo.Builder(0, new ComponentName(mContext, MyJobService.class))
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)// 设置网络条件
                    .setRequiresDeviceIdle(false)// 设置手机是否空闲的条件
                    .build();
            if (mScheduler != null) mScheduler.schedule(jobInfo);
        }
    }

    private void delayTime(){
        if(mScheduler == null) {
            LogUtils.d(TAG," init");
            mScheduler = (JobScheduler) mContext.getSystemService(Context.JOB_SCHEDULER_SERVICE);
            JobInfo jobInfo = new JobInfo.Builder(0, new ComponentName(mContext, MyJobService.class))
                    .setMinimumLatency(5 * 1000)
                    .setOverrideDeadline(10 * 1000)
                    .setRequiresDeviceIdle(false)// 设置手机是否空闲的条件
                    .build();
            if (mScheduler != null) mScheduler.schedule(jobInfo);
        }
    }
}
