package com.example.neo.myapplication.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;

import com.example.neo.myapplication.utils.LogUtils;
import com.example.neo.myapplication.utils.NetworkUtils;

/**
 * Created by neo on 2018/7/13.
 */

public class MyJobService extends JobService{
    @Override
    public boolean onStartJob(JobParameters params) {
        if (NetworkUtils.isNetworkAvailable(this)){
            LogUtils.d("MyJobService", "onStartJob: " );

        }
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        return false;
    }
}
