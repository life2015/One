package com.twtstudio.one;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;


/**
 * Created by 冀辰阳 on 2016/4/19.
 */
public class NetUtils {

    //读取网络上的数据转化为字符串
    public static String readStream(InputStream is) {
        InputStreamReader isr;
        String result = " ";
        try {
            String line = " ";
            isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Bitmap getImageFromUrl(String url) {

        Bitmap bitmap = null;
        try {
            URL mUrl = new URL(url);
            URLConnection connection = mUrl.openConnection();
            InputStream inputStream = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            bitmap = BitmapFactory.decodeStream(bis);
            inputStream.close();
            bis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("jcy","加载bitmap");
        return bitmap;
    }
    public static boolean isonline()
    {
        ConnectivityManager connectivityManager= (ConnectivityManager)OneApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        return (networkInfo!=null&&networkInfo.isConnected());
    }
}
