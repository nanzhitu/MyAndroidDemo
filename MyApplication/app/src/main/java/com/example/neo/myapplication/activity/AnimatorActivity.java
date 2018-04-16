package com.example.neo.myapplication.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;

import com.example.neo.myapplication.utils.constant.AnimatorConstants;

public class AnimatorActivity extends BaseActivity implements View.OnClickListener {

    Button mTranslationYBtn,mChangeBackgroundColorBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_animator);
        mTranslationYBtn = findViewById(R.id.runTranslationY);
        mChangeBackgroundColorBtn = findViewById(R.id.changeBackgroundColor);
    }

    @Override
    protected void initListener() {
        mTranslationYBtn.setOnClickListener(this);
        mChangeBackgroundColorBtn.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.runTranslationY:
                runTranslationY();
                break;
            case R.id.changeBackgroundColor:
                runChangeBackgroundColor();
                break;
            default:
                break;
        }
    }

    private void runTranslationY(){
        ValueAnimator animator = ObjectAnimator.ofFloat(mTranslationYBtn, AnimatorConstants.TRANLATION_Y,0,100,0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationStart(Animator animation) {
                super.onAnimationStart(animation);
            }

            @Override
            public void onAnimationPause(Animator animation) {
                super.onAnimationPause(animation);
            }
        });

        animator.addUpdateListener(animation -> {
            Float value = (Float)animation.getAnimatedValue();
            mTranslationYBtn.setText("now: "+value);
        });
        animator.setDuration(4000);
        animator.start();
    }

    private void runChangeBackgroundColor(){
        ValueAnimator animator = ObjectAnimator.ofInt(mChangeBackgroundColorBtn, AnimatorConstants.BACKGROUND_COLOR, Color.RED,Color.GREEN,Color.BLUE);
        animator.setEvaluator(new ArgbEvaluator());//起到一个颜色变化平缓过度效果
        animator.setDuration(4000);
        animator.start();
    }
}
