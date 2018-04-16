package com.example.neo.myapplication.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Environment;

import java.io.ByteArrayOutputStream;

/**
 * Created by Neo on 2018/4/16.
 */

public final class ImageUtils {

    public static final String DCIM =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
    public static final String DIRECTORY = DCIM + "/Camera";
    //public static final File DIRECTORY_FILE = new File(DIRECTORY);
    public static final String JPEG_POSTFIX = ".jpg";
    public static final String GIF_POSTFIX = ".gif";

    public static boolean isJPGFile(String filename){
        return filename.toLowerCase().endsWith(JPEG_POSTFIX);
    }


    public static synchronized Bitmap toRoundBitmap(Bitmap bitmap, float round) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left, top, right, bottom, dst_left, dst_top, dst_right, dst_bottom;
        if (width <= height) {
            roundPx = width / 2;
            left = 0;
            top = 0;
            right = width;
            bottom = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        } else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            bottom = height;
            width = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }
        if(round != 0) {
            roundPx = round;
        }

        LogUtils.d("ygj"," width: "+width+" height: "+height+" roundPx: "+roundPx);
        LogUtils.d("ygj"," left: "+left+" top: "+top+" right: "+right+" bottom: "+bottom);
        LogUtils.d("ygj"," dst_left: "+dst_left+" dst_top: "+dst_top+" dst_right: "+dst_right+" dst_bottom: "+dst_bottom);
        Bitmap output = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);


        final Paint paint = new Paint();
        final Rect src = new Rect((int) left, (int) top, (int) right, (int) bottom);
        final Rect dst = new Rect((int) dst_left, (int) dst_top, (int) dst_right, (int) dst_bottom);
        final RectF rectF = new RectF(dst);

        paint.setAntiAlias(true);// 设置画笔无锯齿

        canvas.drawARGB(0, 0, 0, 0); // 填充整个Canvas

        // 以下有两种方法画圆,drawRounRect和drawCircle
        // canvas.drawRoundRect(rectF, roundPx, roundPx, paint);// 画圆角矩形，第一个参数为图形显示区域，第二个参数和第三个参数分别是水平圆角半径和垂直圆角半径。
        canvas.drawCircle(roundPx, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));// 设置两张图片相交时的模式,参考http://trylovecatch.iteye.com/blog/1189452
        canvas.drawBitmap(bitmap, src, dst, paint); //以Mode.SRC_IN模式合并bitmap和已经draw了的Circle

        ByteArrayOutputStream logoStream = new ByteArrayOutputStream();
        boolean res = output.compress(Bitmap.CompressFormat.PNG, 100, logoStream);
        byte[] logoBuf = logoStream.toByteArray();// 将图像保存到byte[]中
        Bitmap temp = BitmapFactory.decodeByteArray(logoBuf, 0, logoBuf.length);// 将图像从byte[]中读取生成Bitmap
        return temp;
    }

    public static synchronized Bitmap toRoundBitmap(Bitmap bitmap) {
        return toRoundBitmap(bitmap,0);
    }
}
