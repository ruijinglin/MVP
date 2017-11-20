package com.android.rui.mvp.demo.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.rui.mvp.R;
import com.android.rui.mvp.base.BaseActivity;
import com.android.rui.mvp.demo.contract.MainContract;
import com.android.rui.mvp.demo.presenter.MainPresenter;

/**
 * Main的 V层
 *
 * @author: RuiJingLin
 * @date 2017/11/15
 */

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View, View.OnClickListener {

    private Button mBtn;
    private TextView mTv;

    @Override
    protected int setRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainPresenter setPresenter() {
        return new MainPresenter(this, this);
    }

    @Override
    protected void onViewCreate(Bundle savedInstanceState) {
        /**
         * 可以结合ButterKnife搭建，更简洁
         */
        mBtn = (Button) findViewById(R.id.btn);
        mTv = (TextView) findViewById(R.id.tv);
        mBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                /**
                 * 这里只是做一个简单的测试：点击按钮，V 可以感知到，但是这里的业务一定要传输给 P层处理
                 */
                mPresenter.getDataFromServer();
                break;
            default:
                break;
        }
    }


    /**
     * V 层负责傻瓜似的做显示
     *
     * @param msg
     */
    @Override
    public void showData(String msg) {
        mTv.setText(msg);
    }
}
