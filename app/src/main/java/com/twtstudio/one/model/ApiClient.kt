package com.twtstudio.one.model

import android.util.Log

import com.twtstudio.one.Bean.BeanListMonth
import com.twtstudio.one.presenter.InfoBeanPresenter
import com.twtstudio.one.presenter.RecyclerViewAdapter

import java.io.IOException

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by jcy on 2016/5/14.
 */
class ApiClient(var infoBeanPresenter: InfoBeanPresenter) {
    val base_url = "http://v3.wufazhuce.com:8000/api/"
    var retrofit:Retrofit
    var One_Api: Api

    init {
        retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(base_url).build()
        One_Api = retrofit.create(Api::class.java)
    }

    fun get() {
        val call = One_Api.getListBean("2017-04")
        call.enqueue(object : Callback<BeanListMonth> {
            override fun onResponse(call: Call<BeanListMonth>, response: Response<BeanListMonth>) {
                infoBeanPresenter.postList(response.body().data)
                println(response.body().data)
                Log.d("jcy", "retrofit----------------->ok")
            }

            override fun onFailure(call: Call<BeanListMonth>, t: Throwable) {
                Log.d("jcyerror", "retrofit失败")
            }
        })
    }
}
