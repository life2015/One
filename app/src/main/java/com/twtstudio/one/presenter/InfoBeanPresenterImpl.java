package com.twtstudio.one.presenter;

import android.content.Context;

import com.twtstudio.one.model.GetBeanList;
import com.twtstudio.one.model.GetBeanListImpl;
import com.twtstudio.one.model.OneBean;
import com.twtstudio.one.view.InfoView;

/**
 * Created by jcy on 2016/5/9.
 */
public class InfoBeanPresenterImpl implements InfoBeanPresenter {
    InfoView infoView;
    GetBeanList getBeanList;

    public InfoBeanPresenterImpl(InfoView infoView, Context context)
    {
        this.infoView = infoView;
        this.getBeanList = new GetBeanListImpl(context,this);
    }

    @Override
    public  void psotInfoBean(OneBean bean) {
        synchronized(this)
        { infoView.insertInfoItem(bean);}
    }

    @Override
    public void getData() {
        getBeanList.getPreInfo();
    }
}
