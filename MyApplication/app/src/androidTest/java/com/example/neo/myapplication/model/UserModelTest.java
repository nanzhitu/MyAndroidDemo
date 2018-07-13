package com.example.neo.myapplication.model;

import android.nfc.Tag;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Neo on 2018/6/5.
 */
public class UserModelTest {

    private static final String TAG = "UserModelTest";
    private UserModel userModel;
    @Before
    public void setUp() throws Exception {
        userModel = new UserModel("neo","123456");
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getName() throws Exception {
        Log.d(TAG,"getName = "+userModel.getName());
    }

    @Test
    public void getPasswd() throws Exception {
        Log.d(TAG,"getPasswd = "+userModel.getPasswd());
    }

    @Test
    public void checkUserValidity() throws Exception {
        Log.d(TAG,"checkUserValidity = "+userModel.checkUserValidity("qqq","11212"));
    }
}