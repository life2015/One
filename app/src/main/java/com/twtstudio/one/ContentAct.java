package com.twtstudio.one;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Build;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.twtstudio.one.model.BitmapSerziable;
import com.twtstudio.one.model.OneStoryBean;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class ContentAct extends AppCompatActivity {
    WebView webView;
    String CONTENT_BASE_URL = "http://211.152.49.184:7001/OneForWeb/one/getOneContentInfo?strDate=";
    ImageView imageview;

    //CoordinatorLayout coordinatorLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        //透明状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //透明导航栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_content);
        toolbar.setTitle("Story");
        setSupportActionBar(toolbar);
        webView = (WebView) findViewById(R.id.webView_story);
        imageview = (ImageView) findViewById(R.id.image_content_one);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String s = bundle.getString("index");
        String bitmapurl = bundle.getString("bitmapurl");
        new MyAsyncTask().execute(s);
        new BitmapTask().execute(bitmapurl);

    }

    class MyAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(ContentAct.this, "正在加载...", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... params) {
            String reponse = null;
            try {
                URL url = new URL(CONTENT_BASE_URL + params[0]);
                reponse = NetUtils.readStream(url.openStream());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Gson gson = new Gson();
            OneStoryBean storyBean = gson.fromJson(reponse, OneStoryBean.class);
            String content = storyBean.getContentEntity().getStrContent();
            return content;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("jcycont", s);
            webView.loadData(s, "text/html;charset=utf-8", null);
        }
    }

    class BitmapTask extends AsyncTask<String, Void, Bitmap> {

        @Override
        protected Bitmap doInBackground(String... params) {
            return NetUtils.getImageFromUrl(params[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            imageview.setImageBitmap(bitmap);
        }
    }
}
