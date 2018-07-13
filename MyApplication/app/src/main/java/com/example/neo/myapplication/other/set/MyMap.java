package com.example.neo.myapplication.other.set;

import android.content.Context;

import com.example.neo.myapplication.test.ITest;
import com.example.neo.myapplication.utils.LogUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Neo on 2018/7/13.
 */

public class MyMap extends ITest {

    private static final String TAG = "MyMap";

    Map<Integer, String> mMap = new HashMap<Integer, String>();
    private static MyMap sMap;
    private MyMap(){

    }

    public static MyMap getInstance(){
        if(sMap == null){
            synchronized (MyMap.class){
                if(sMap == null){
                    sMap = new MyMap();
                }
            }
        }
        return sMap;
    }

    @Override
    public void init(Context context){


    }

    @Override
    public void init() {
        initMap();
    }

    @Override
    public void test(){
        getAllKeyValue();
        getAllValue();
        getAllKeyValueByEntry();
    }

    private void initMap(){
        mMap.put(1, "aaaa");
        mMap.put(2, "bbbb");
        mMap.put(3, "cccc");
    }


    private void getAllKeyValue(){
        Set<Integer> ks = mMap.keySet();
        Iterator<Integer> it = ks.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            String value = mMap.get(key);
            LogUtils.d(TAG,"getAllKeyValue key=" + key + " value=" + value);
        }
    }

    private void getAllValue(){
        Collection<String> vs = mMap.values();
        Iterator<String> it = vs.iterator();
        while (it.hasNext()) {
            String value = it.next();
            LogUtils.d(TAG," getAllValue value=" + value);
        }
    }

    private void getAllKeyValueByEntry(){
        Set<Map.Entry<Integer, String>> es = mMap.entrySet();

        Iterator<Map.Entry<Integer, String>> it = es.iterator();

        while (it.hasNext()) {

            // 返回的是封装了key和value对象的Map.Entry对象
            Map.Entry<Integer, String> en = it.next();

            // 获取Map.Entry对象中封装的key和value对象
            Integer key = en.getKey();
            String value = en.getValue();

            LogUtils.d(TAG,"getAllKeyValueByEntry key=" + key + " value=" + value);
        }

    }
}
