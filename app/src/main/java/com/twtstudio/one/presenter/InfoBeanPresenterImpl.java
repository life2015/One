package com.twtstudio.one.presenter;

import android.content.Context;

import com.twtstudio.one.Bean.BeanListMonth;
import com.twtstudio.one.model.ApiClient;
import com.twtstudio.one.view.InfoView;

import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public class InfoBeanPresenterImpl implements InfoBeanPresenter {
    InfoView infoView;
    //GetBeanList getBeanList;
    ApiClient apiClient;

    public InfoBeanPresenterImpl(InfoView infoView, Context context)
    {
        this.infoView = infoView;
        //this.getBeanList = new GetBeanListImpl(context,this);
       this.apiClient=new ApiClient(this);
    }


    @Override
    public void getData() {
        apiClient.get();
    }

    @Override
    public void postList(List<BeanListMonth.DataBean> dataBeanList) {
        infoView.addList(dataBeanList);
    }
}
