package com.android.rui.mvp.base;

import android.util.Log;

/**
 * Presenter基类
 *
 * @author: RuiJingLin
 * @date 2017/11/15
 */

public class BasePresenter<V extends BaseView> {

    protected V mView;

    /**
     * View 的绑定
     *
     * @param mvpView
     */
    public void attachView(V mvpView) {
        this.mView = mvpView;
    }

    /**
     * View 解除绑定
     */
    public void detachView() {
        this.mView = null;
        Log.e("TAG", "detachView: *----------------" );
    }

    public boolean isViewBind() {
        return mView != null;
    }


    public V getView() {
        return mView;
    }

}
