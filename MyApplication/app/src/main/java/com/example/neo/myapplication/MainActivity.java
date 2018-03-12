package com.example.neo.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.neo.myapplication.activity.Activity0;

public class MainActivity extends AppCompatActivity {

    Button activity0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity0 = findViewById(R.id.button);
        activity0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity0.class);
                startActivity(intent);
            }
        });
    }
}
