package com.didi.virtualapk.demo;

import com.didi.virtualapk.demo.utils.MyConstants;
import com.didi.virtualapk.demo.utils.MyUtils;

import android.app.Application;
import android.os.Process;
import android.util.Log;

public class MyApplication extends Application {

    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        String processName = MyUtils.getProcessName(getApplicationContext(),
                Process.myPid());
        new Thread(new Runnable() {

            @Override
            public void run() {
                doWorkInBackground();
            }
        }).start();

        Log.e(MyConstants.PLUGIN_TAG, "启动 Application, 进程id = "+ android.os.Process.myPid());
    }

    private void doWorkInBackground() {

    }
}
