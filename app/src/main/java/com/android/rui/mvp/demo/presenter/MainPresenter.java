package com.android.rui.mvp.demo.presenter;


import com.android.rui.mvp.base.BasePresenter;
import com.android.rui.mvp.demo.contract.MainContract;
import com.android.rui.mvp.demo.view.MainActivity;

/**
 * Main的 P层
 *
 * @author: RuiJingLin
 * @date 2017/11/15
 */

public class MainPresenter extends BasePresenter<MainContract.View> implements MainContract {


    public MainPresenter(MainContract.View view, MainActivity mainActivity) {
        //这里是将View做绑定
        attachView(view);
        //mainActivity对象根据需要可选择不传
    }



    @Override
    public void getDataFromServer() {
        /**
         * 这里模拟一些网络请求等业务
         */

        //-------------------------------------------------------------------


        //因为构造已经做了绑定，getView方法就可以得到所有封装起来的V层方法，请求到的数据显示给V层
        getView().showData("{这是一条来自服务器的数据，你看到了吗？}");

        /**
         * 注意到，这里只做了V层与P层的交互，因为我认为像类似于网络请求，数据库操作，或者其他的业务逻辑，
         * 你绝对不会直接一路写下来的，一定是已经做了封装，经过这些封装之后，你的调用本身就已经够简洁了，
         * 没有必要再去开辟一些接口与P层交互，回调，所有这里就直接在P层写这些封装好的业务逻辑即可。
         */

    }
}
