package com.android.rui.mvp.demo.contract;

import com.android.rui.mvp.base.BaseView;

/**
 * 业务的控制器，主要是为 V层和 P层提供交互的方法
 *
 * @author: RuiJingLin
 * @date 2017/11/15
 */

public interface MainContract {

    /**
     * 这里是提供 V层调用 P层的方法
     */

    /**
     * 从服务器获取数据
     */
    void getDataFromServer();

    interface View extends BaseView {
        /**
         * 这里是提供 P调用 V层的方法
         */

        /**
         *
         * @param msg
         */
        void showData(String msg);
    }
}
