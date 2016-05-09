package com.twtstudio.one.presenter;

import com.twtstudio.one.model.OneBean;

import java.util.List;

/**
 * Created by jcy on 2016/5/9.
 */
public interface InfoBeanPresenter {
    /**
     * presenter的回调方法，model回调推送列表
     * @param bean
     */
     void psotInfoBean(OneBean bean);

    void getData();

}
