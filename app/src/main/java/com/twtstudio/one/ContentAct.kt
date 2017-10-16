package com.twtstudio.one

import android.content.Intent
import android.graphics.Bitmap
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.WindowManager
import android.webkit.WebView
import android.widget.ImageView
import android.widget.Toast

import com.google.gson.Gson
import com.twtstudio.one.Bean.Bean
import com.twtstudio.one.Bean.OneStoryBean
import com.twtstudio.one.model.ApiClient

import java.io.IOException
import java.net.MalformedURLException
import java.net.URL

class ContentAct : AppCompatActivity() {
    internal var webView: WebView? = null
    internal var CONTENT_BASE_URL = "http://211.152.49.184:7001/OneForWeb/one/getOneContentInfo?strDate="
    internal var imageview: ImageView? = null

    //CoordinatorLayout coordinatorLayout;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)


        //透明状态栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        //透明导航栏
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)

        val toolbar = findViewById<Toolbar>(R.id.toolbar_content)
        toolbar.title = "Story"
        setSupportActionBar(toolbar)
        webView = findViewById(R.id.webView_story)
        imageview = findViewById(R.id.image_content_one)
        val intent = intent
        val bundle = intent.extras
        val s = bundle.getString("index")
        val bitmapurl = bundle.getString("bitmapurl")
        MyAsyncTask().execute(s)
        BitmapTask().execute(bitmapurl)


    }

    internal inner class MyAsyncTask : AsyncTask<String, Void, String>() {

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(this@ContentAct, "正在加载...", Toast.LENGTH_SHORT).show()
        }

        override fun doInBackground(vararg params: String): String {
            var response: String? = null
            try {
                val url = URL(CONTENT_BASE_URL + params[0])

                response = NetUtils.readStream(url.openStream())
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            val gson = Gson()
            val storyBean = gson.fromJson(response, OneStoryBean::class.java)
            val content = storyBean.contentEntity!!.strContent
            return content!!
        }

        override fun onPostExecute(s: String) {
            super.onPostExecute(s)
            Log.d("jcycont", s)
            webView?.loadData(s, "text/html;charset=utf-8", null)
        }
    }

    internal inner class BitmapTask : AsyncTask<String, Void, Bitmap>() {

        override fun doInBackground(vararg params: String): Bitmap {
            return NetUtils.getImageFromUrl(params[0])
        }

        override fun onPostExecute(bitmap: Bitmap) {
            super.onPostExecute(bitmap)
            imageview?.setImageBitmap(bitmap)
        }
    }
}
