package com.twtstudio.one.view;

import com.twtstudio.one.Bean.BeanListMonth;
import com.twtstudio.one.Bean.BeanListMonth.DataBean;

import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public interface InfoView {
    /**
     * 讲list传入view
     * @param oneBeanList
     */
    void setInfoListView(List<BeanListMonth.DataBean> oneBeanList);

    /**
     * 更新infolist
     * @param newOneBeanList
     */
    void updateInfoList(List<BeanListMonth.DataBean> newOneBeanList);


    /**
     * 适配器单个插入
     * @param bean
     */
    void insertInfoItem(BeanListMonth.DataBean bean);

    /**
     * 适配器批量插入
     * @param dataBeanList 插入的list源
     */
    void addList(List<BeanListMonth.DataBean> dataBeanList);
}
