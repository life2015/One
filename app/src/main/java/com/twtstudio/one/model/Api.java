package com.twtstudio.one.model;

import com.twtstudio.one.Bean.BeanListMonth;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by jcy on 2016/5/14.
 */
public interface Api {
    /**
     * 获取这个月的图文内容
     * @param month 输入月份
     * @return
     */
    @GET("hp/bymonth/{month}")
    Call<BeanListMonth> getListBean(@Path("month") String month);



}
