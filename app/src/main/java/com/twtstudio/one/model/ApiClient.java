package com.twtstudio.one.model;

import com.twtstudio.one.Bean.BeanListMonth;
import com.twtstudio.one.presenter.InfoBeanPresenter;

import java.io.IOException;

import retrofit2.Call;
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
        Call<BeanListMonth> call=One_Api.getListBean("2016-5");
        try {
            BeanListMonth beanListMonth=call.execute().body();
            infoBeanPresenter.postList(beanListMonth.getData());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
