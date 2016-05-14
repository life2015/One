package com.twtstudio.one.model;

import android.util.Log;

import com.twtstudio.one.Bean.BeanListMonth;
import com.twtstudio.one.presenter.InfoBeanPresenter;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jcy on 2016/5/14.
 */
public class ApiClient {
    InfoBeanPresenter infoBeanPresenter;
    String base_url="http://v3.wufazhuce.com:8000/api/";
    Retrofit retrofit;
    Api One_Api;

    public ApiClient(InfoBeanPresenter infoBeanPresenter) {
        this.infoBeanPresenter = infoBeanPresenter;
        retrofit=new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(base_url).build();
        One_Api=retrofit.create(Api.class);
    }

    public void get()
    {
        Call<BeanListMonth> call=One_Api.getListBean("2016-04");
        call.enqueue(new Callback<BeanListMonth>() {
            @Override
            public void onResponse(Call<BeanListMonth> call, Response<BeanListMonth> response) {
                infoBeanPresenter.postList(response.body().getData());
                System.out.println(response.body().getData());
                Log.d("jcy","retrofit----------------->ok");
            }

            @Override
            public void onFailure(Call<BeanListMonth> call, Throwable t) {
                Log.d("jcyerror","retrofit失败");
            }
        });
    }
}
