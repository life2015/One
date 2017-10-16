package com.twtstudio.one.twt

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET



/**
 * Created by retrox on 14/10/2017.
 */
interface ScheduleApi {
    @GET("classtable")
    fun getClassTable(): Call<ClassTable>
}