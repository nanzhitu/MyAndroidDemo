package com.example.neo.myapplication.other.set;

import com.example.neo.myapplication.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Neo on 2018/7/13.
 */

public class MySet extends ISet{

    private static final String TAG = "MySet";

    Set mHashSet = new HashSet();

    private static MySet sMySet;
    private MySet(){

    }

    public static MySet getInstance(){
        if(sMySet == null){
            synchronized (MySet.class){
                if(sMySet == null){
                    sMySet = new MySet();
                }
            }
        }
        return sMySet;
    }

    @Override
    public void init(){
        initSet();
    }

    @Override
    public void test(){
        printHashSet();
        printLinkedHashSet();
    }

    private void initSet(){

        mHashSet.add("世界军事");
        mHashSet.add("兵器知识");
        mHashSet.add("舰船知识");
        mHashSet.add("汉和防务");
    }

    private void printHashSet(){
        Iterator it = mHashSet.iterator();
        while (it.hasNext()) {
            LogUtils.d(TAG," HashSet: "+it.next());
        }
    }

    private void printLinkedHashSet(){
        ArrayList<String> aList = new ArrayList<>();
        aList.add("b");
        aList.add("a");
        aList.add("a");
        aList.add("b");
        aList.add("c");
        aList.add("c");
        LinkedHashSet<String> hSet = new LinkedHashSet<>();
        hSet.addAll(aList);
        aList.clear();
        aList.addAll(hSet);
        LogUtils.d(TAG," LinkedHashSet: "+aList);
    }
}
