package com.android.rui.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity基类
 *
 * @author: RuiJingLin
 * @date 2017/11/15
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity {

    /**
     * 在基类持有Presenter引用即可
     */
    protected P mPresenter;

    /**
     * 抽象给子类设置根布局文件
     *
     * @return
     */
    protected abstract int setRootViewId();

    /**
     * 设置Presenter对象
     *
     * @return
     */
    protected abstract P setPresenter();

    /**
     * 抽象给子类代替onCreate方法,处理逻辑
     *
     * @param savedInstanceState
     */
    protected abstract void onViewCreate(Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setRootViewId());

        if (mPresenter == null) {
            mPresenter = setPresenter();
        }

        onViewCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        /**
         * 这里进行View对象的回收,防止内存泄漏
         */
        if (mPresenter != null && mPresenter.isViewBind()) {
            mPresenter.detachView();
        }
        super.onDestroy();
    }
}
