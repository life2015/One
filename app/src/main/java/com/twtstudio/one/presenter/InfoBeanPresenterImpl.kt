package com.twtstudio.one.presenter

import android.content.Context

import com.twtstudio.one.Bean.BeanListMonth
import com.twtstudio.one.model.ApiClient
import com.twtstudio.one.view.InfoView

/**
 * Created by jcy on 2016/5/9.
 */
class InfoBeanPresenterImpl(val infoView: InfoView,val context: Context) : InfoBeanPresenter {
    //GetBeanList getBeanList;
    val apiClient: ApiClient = ApiClient(this)

    override fun getData() {
        apiClient.get()
    }

    override fun postList(dataBeanList: List<BeanListMonth.DataBean>) {
        infoView.addList(dataBeanList)
    }

    override fun loadMore() {
        apiClient.get()
    }
}
