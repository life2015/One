package com.twtstudio.one.presenter;

import com.twtstudio.one.Bean.BeanListMonth;

import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public interface InfoBeanPresenter {


    void getData();

    void postList(List<BeanListMonth.DataBean> dataBeanList);

    void loadMore();

}
