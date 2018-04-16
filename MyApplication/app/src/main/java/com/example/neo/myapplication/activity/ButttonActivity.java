package com.example.neo.myapplication.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;
import com.example.neo.myapplication.utils.ImageUtils;

public class ButttonActivity extends BaseActivity implements View.OnClickListener {

    ImageButton mRoundBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_buttton);
        mRoundBtn = findViewById(R.id.round);

        Bitmap bitmap = BitmapFactory.decodeResource( getResources(), R.mipmap.picture);
        mRoundBtn.setBackground(new BitmapDrawable(ImageUtils.toRoundBitmap(bitmap)));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {

    }
}
