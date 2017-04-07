package com.twtstudio.one

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import java.io.*


import java.net.URL
import java.net.URLConnection


/**
 * Created by 冀辰阳 on 2016/4/19.
 */
object NetUtils {

    //读取网络上的数据转化为字符串
    fun readStream(`is`: InputStream): String {
        val isr: InputStreamReader
        val result = StringBuilder()
        try {
            var line = " "
            isr = InputStreamReader(`is`, "utf-8")
            val br = BufferedReader(isr)
            br.readLines().forEach {
                result.append(it)
            }
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }


        return result.toString()
    }

    fun getImageFromUrl(url: String): Bitmap {

        var bitmap: Bitmap? = null
        try {
            val mUrl = URL(url)
            val connection = mUrl.openConnection()
            val inputStream = connection.getInputStream()
            val bis = BufferedInputStream(inputStream)
            bitmap = BitmapFactory.decodeStream(bis)
            inputStream.close()
            bis.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }

        Log.d("jcy", "加载bitmap")
        return bitmap!!
    }

    fun isonline(): Boolean {
        val connectivityManager = OneApp.getContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }
}
