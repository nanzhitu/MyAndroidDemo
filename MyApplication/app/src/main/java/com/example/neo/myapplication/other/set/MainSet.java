package com.example.neo.myapplication.other.set;

/**
 * Created by Neo on 2018/7/13.
 */

public class MainSet extends ISet{

    private static final String TAG = "MainSet";
    private static MainSet sMainSet;
    private MainSet(){

    }

    public static MainSet getInstance(){
        if(sMainSet == null){
            synchronized (MainSet.class){
                if(sMainSet == null){
                    sMainSet = new MainSet();
                }
            }
        }
        return sMainSet;
    }

    @Override
    public void init(){
        MyMap.getInstance().init();
        MySet.getInstance().init();
    }

    @Override
    public void test(){
        MyMap.getInstance().test();
        MySet.getInstance().test();
    }

}
