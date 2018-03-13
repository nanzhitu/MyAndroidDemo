package com.example.neo.myapplication.activity;

import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;
import com.example.neo.myapplication.utils.LogUtils;

public class Activity0 extends BaseActivity implements View.OnClickListener{
    private static final String TAG = Activity0.class.getSimpleName();

    TextView textView;
    TextView title;
    @Override
    protected void initView() {
        setContentView(R.layout.activity0);
        textView = (TextView) findViewById(R.id.text0);
        title = findViewById(R.id.tv_title);
        LogUtils.d(TAG,"initView");
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void init() {
        LogUtils.d(TAG,"init");
        mHandler.sendEmptyMessage(0);
        test();
        findViewById(R.id.btn_back).setOnClickListener(this);
    }

    @Override
    protected void handleMessage(Message msg) {
        switch (msg.what) {
            case 0:
                textView.setText("message0 success");
                break;
            case 1:

                break;
            default:
                break;
        }
    }


    private void test(){
        Message message = new Message();
        message.what = 0;
        mHandler.sendMessage(message);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                this.finish();
                break;
            default:
                break;
        }
    }
}
