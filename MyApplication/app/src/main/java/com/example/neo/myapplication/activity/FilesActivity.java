package com.example.neo.myapplication.activity;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;
import com.example.neo.myapplication.utils.PermissionUtils;

import  com.example.neo.myapplication.utils.FileUtils;

public class FilesActivity extends BaseActivity implements View.OnClickListener {

    Button mGetFileBtn;
    TextView mTextView;
    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected void initView() {
        setContentView(R.layout.activity_files);
        mTextView = findViewById(R.id.filepath);
        mGetFileBtn = findViewById(R.id.getpath);

    }

    @Override
    protected void initListener() {
        mGetFileBtn.setOnClickListener(this);
    }

    @Override
    protected void init() {
        String [] permission = {"android.permission.WRITE_EXTERNAL_STORAGE",
                "android.permission.READ_EXTERNAL_STORAGE"};
        PermissionUtils.needPermission(this,MY_PERMISSIONS_REQUEST_READ_CONTACTS,permission);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.getpath:
                Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                intent.setType("*/*");//设置类型，我这里是任意类型，任意后缀的可以这样写。
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent,1);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            String path = FileUtils.getPathfromIntent(this,data);
            mTextView.setText(path);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_CONTACTS:
                break;
            default:
                break;
        }
    }
}
