package com.example.neo.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.neo.myapplication", appContext.getPackageName());
    }

    /**
     * 单元测试，测试函数
     */
    @Test
    public void test2() {
        boolean result = "18210741899".matches("\\d{11}");
        Log.i("tag", "#####:" + result);
        /**
         * 验证邮箱
         */
        assertEquals("result:", result, true);
    }
}
