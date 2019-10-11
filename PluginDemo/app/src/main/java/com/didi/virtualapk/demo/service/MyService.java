package com.didi.virtualapk.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.didi.virtualapk.demo.utils.MyConstants;

public class MyService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(MyConstants.PLUGIN_TAG, "插件 service 已经启动, 进程id= " + android.os.Process.myPid());
    }

    public class ServiceBinder extends Binder {
        public void binderTest() {
            test();
        }
    }

    public void test() {
        Log.e(MyConstants.PLUGIN_TAG, "service test");
    }
}
