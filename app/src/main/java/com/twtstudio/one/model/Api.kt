package com.twtstudio.one.model

import com.twtstudio.one.Bean.BeanListMonth

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import rx.Observable

/**
 * Created by jcy on 2016/5/14.
 */
interface Api {
    /**
     * 获取这个月的图文内容
     * @param month 输入月份
     * *
     * @return
     */
    @GET("hp/bymonth/{month}")
    fun getListBean(@Path("month") month: String): Observable<BeanListMonth>


}
