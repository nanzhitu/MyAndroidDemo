package com.neo.samplebutterknife;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView( R.id.text)
    public TextView textView;

    @BindString(R.string.app_name)  //绑定资源文件中string字符串
    String str;

    @BindArray(R.array.city)  //绑定string里面array数组
    String [] citys ;


    @BindView( R.id.imageView ) //绑定ImageView 控件
    public ImageView imageView ;

    @BindBitmap( R.mipmap.ic_user)//绑定Bitmap 资源
    public Bitmap bitmap ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        textView.setText("123456");
        imageView.setImageBitmap(bitmap);
    }
}
