package com.example.neo.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;

public class UtilsActivity extends BaseActivity implements View.OnClickListener {

    Button mFileBtn,mOtherBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_utils);
        mFileBtn = findViewById(R.id.file);
        mOtherBtn = findViewById(R.id.other);
    }

    @Override
    protected void initListener() {
        mFileBtn.setOnClickListener(this);
        mOtherBtn.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.file:
                Intent intent0 = new Intent(this, FilesActivity.class);
                startActivity(intent0);
                break;
            case R.id.other:
                Intent intent1 = new Intent(this, OtherUtilsActivity.class);
                startActivity(intent1);
                break;
            default:
                break;
        }
    }
}
