package com.kaolafm.kradio.component;

import android.os.Bundle;
import com.kaolafm.kradio.lib.R;
import com.kaolafm.kradio.lib.base.mvp.IPresenter;
import com.kaolafm.kradio.lib.base.ui.BaseActivity;

/**
 * @author Donald Yan
 * @date 2019-07-09
 */
public class TestActivity extends BaseActivity {

    @Override
    public int getLayoutId() {
        return R.layout.layout_normal_toast;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        ComponentClient.obtainBuilder("TestAComponent")
                .cancelOnDestroyWith(this)
                .setActionName("get")
                .isCallbackOnMainThread(true)
                .build().callAsync(new ComponentCallback() {
            @Override
            public void onResult(Caller caller, ComponentResult result) {
                System.out.println("caller="+caller+", result="+result.getData());
            }
        });
    }

    @Override
    public void initData() {

    }

    @Override
    protected IPresenter createPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("TestActivity.onDestroy");
    }
}
