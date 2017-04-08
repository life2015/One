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
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.functions.Action1
import rx.functions.Action2
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription

/**
 * Created by jcy on 2016/5/14.
 */
class ApiClient(var infoBeanPresenter: InfoBeanPresenter) {
    val base_url = "http://v3.wufazhuce.com:8000/api/"
    var retrofit: Retrofit
    var One_Api: Api
    val subscriptionMap = CompositeSubscription()

    init {
        retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url).build()
        One_Api = retrofit.create(Api::class.java)
    }

    fun get() {

        val subscription =
                Observable.merge(One_Api.getListBean("2017-04"), One_Api.getListBean("2017-03"), One_Api.getListBean("2017-02"))
                        .subscribeOn(Schedulers.io())
                        .map { it.data }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ it -> infoBeanPresenter.postList(it) }, Throwable::printStackTrace)
        subscriptionMap.add(subscription)
    }

    fun getasList(action: (ArrayList<BeanListMonth.DataBean>) -> Unit) {

        val subsciprtion = Observable.merge(One_Api.getListBean("2017-04"), One_Api.getListBean("2017-03"), One_Api.getListBean("2017-02"))
                .subscribeOn(Schedulers.io())
                .map { it.data }
                .flatMap { Observable.from(it) }
                .collect({ ArrayList<BeanListMonth.DataBean>() },
                        { t1, t2 -> t1.add(t2) })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action, Throwable::printStackTrace)

        subscriptionMap.add(subsciprtion)
    }

    fun unbind() {
        if (!subscriptionMap.isUnsubscribed) {
            subscriptionMap.unsubscribe()
        }
    }
}
