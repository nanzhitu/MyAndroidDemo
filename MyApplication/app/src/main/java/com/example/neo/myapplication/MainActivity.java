package com.example.neo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neo.myapplication.activity.Activity0;
import com.example.neo.myapplication.activity.LoginActivity;
import com.example.neo.myapplication.activity.UtilsActivity;
import com.example.neo.myapplication.activity.ViewActivity;

public class MainActivity extends AppCompatActivity {

    Button activity0,mvp,view,utils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity0 = findViewById(R.id.button);
        mvp = findViewById(R.id.mvp);
        view = findViewById(R.id.button2);
        utils = findViewById(R.id.utils);

        activity0.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, Activity0.class);
            startActivity(intent);
        });

        mvp.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        });

        view.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ViewActivity.class);
            startActivity(intent);
        });

        utils.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this,UtilsActivity.class);
            startActivity(intent);
        });
    }
}
