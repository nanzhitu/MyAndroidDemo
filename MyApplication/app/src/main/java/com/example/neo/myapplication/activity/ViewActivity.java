package com.example.neo.myapplication.activity;

import android.content.Intent;
import android.os.Message;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;

public class ViewActivity extends BaseActivity implements View.OnClickListener {

    Button mAnimatorBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_view);
        mAnimatorBtn = findViewById(R.id.animator);
    }

    @Override
    protected void initListener() {
        mAnimatorBtn.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.animator:
                Intent intent = new Intent(this, AnimatorActivity.class);
                startActivity(intent);
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
