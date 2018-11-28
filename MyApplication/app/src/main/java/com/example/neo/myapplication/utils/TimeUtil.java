package com.example.neo.myapplication.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Neo on 2018/11/28.
 */

public class TimeUtil {

    /**
    * 将时间戳转换为时间
    */
    public static String stampToDate(long s){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(s*1000);
        res = simpleDateFormat.format(date);
        return res;
    }

    /**
    * 将时间转换为时间戳
    */
    public static long dateToStamp(String s){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        return ts;
    }

    /**
     * 计算出下一月的时间
     *
     * @param currentTime 最近一次触发的时间值
     */
    private static long getNextMonthTime(long currentTime) {
        return getNextTime(currentTime, Calendar.MONTH,1);
    }

    /**
     * 计算出下一年的时间
     *
     * @param currentTime 最近一次触发的时间值
     */
    private static long getNextYearTime(long currentTime) {
        return getNextTime(currentTime,Calendar.YEAR,1);
    }

    /**
     * 计算出下一个时间
     *
     * @param currentTime 最近一次触发的时间值
     * @param field 按(年、月...)增减
     * @param amount 增减数值
     */
    private static long getNextTime(long currentTime,int field, int amount){
        Date date = new Date(currentTime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(field,amount);
        return calendar.getTimeInMillis();
    }
}
