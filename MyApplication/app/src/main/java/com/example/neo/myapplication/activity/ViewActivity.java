package com.example.neo.myapplication.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Message;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;
import com.example.neo.myapplication.utils.LogUtils;

public class ViewActivity extends BaseActivity implements View.OnClickListener {

    Button mAnimatorBtn,mButtonAllBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_view);
        mAnimatorBtn = findViewById(R.id.animator);
        mButtonAllBtn = findViewById(R.id.buttonall);
    }

    @Override
    protected void initListener() {
        mAnimatorBtn.setOnClickListener(this);
        mButtonAllBtn.setOnClickListener(this);
    }

    @Override
    protected void init() {
        TypedArray a = obtainStyledAttributes(null, R.styleable.CameraView, 0,
                R.style.Widget_CameraView);
        LogUtils.d(TAG,"aspectRatio =  "+a.getString(R.styleable.CameraView_aspectRatio));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.animator:
                Intent intent = new Intent(this, AnimatorActivity.class);
                startActivity(intent);
                break;
            case R.id.buttonall:
                Intent intent0 = new Intent(this, ButttonActivity.class);
                startActivity(intent0);
                break;
            default:
                break;
        }
    }

    @Override
    protected void handleMessage(Message msg) {
        super.handleMessage(msg);
    }
}
