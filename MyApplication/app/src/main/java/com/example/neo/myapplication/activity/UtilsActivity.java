package com.example.neo.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;

public class UtilsActivity extends BaseActivity implements View.OnClickListener {

    Button mFileBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_utils);
        mFileBtn = findViewById(R.id.file);
    }

    @Override
    protected void initListener() {
        mFileBtn.setOnClickListener(this);
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
            default:
                break;
        }
    }
}
