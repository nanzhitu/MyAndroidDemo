package com.example.neo.myapplication.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.neo.myapplication.R;
import com.example.neo.myapplication.base.BaseActivity;
import com.example.neo.myapplication.utils.GsonUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

/**
 * Created by Neo on 2018/5/31.
 */

public class OtherUtilsActivity extends BaseActivity {

    TextView mCls2Json,mJson2Cls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected void initView() {
        setContentView(R.layout.activity_other_utils);
        mCls2Json = findViewById(R.id.textView);
        mJson2Cls = findViewById(R.id.textView2);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void init() {
        User user = new User("Neo","男",18);
        String jtext = GsonUtils.toJson(user);
        mCls2Json.setText(jtext);
        String name = "";
        try {
            JSONObject jsonObject = new JSONObject(jtext);
            name = jsonObject.getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }



        User user1 = GsonUtils.getObject(jtext, User.class);
        mJson2Cls.setText(user1.toString()+"\n"+"name = "+name);
    }


    private class User{
        String name;
        String sex;
        int age;

        public User(String name,String sex, int age){
            this.name = name;
            this.sex = sex;
            this.age = age;

        }

        @Override
        public String toString() {
            return " name: " + name+
                    " sex: " + sex +
                    " age: " + age ;
        }
    }
}
