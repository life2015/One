package com.twtstudio.one.view;

import com.twtstudio.one.model.OneBean;

import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public interface InfoView {
    /**
     * 讲list传入view
     * @param oneBeanList
     */
    void setInfoListView(List<OneBean> oneBeanList);

    /**
     * 更新infolist
     * @param newOneBeanList
     */
    void updateInfoList(List<OneBean> newOneBeanList);

    /**
     * 适配器单个插入
     * @param bean
     */
    void insertInfoItem(OneBean bean);
}
