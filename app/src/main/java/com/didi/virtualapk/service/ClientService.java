package com.didi.virtualapk.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.didi.virtualapk.util.HostConstants;
import com.didi.virtualapk.util.LoadPluginUtil;


//adb shell am startservice -n com.didi.virtualapk/com.didi.virtualapk.service.ClientService -a com.kaolafm.sdk.client

public class ClientService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(HostConstants.HOST_TAG, "宿主  service 启动 id = "+ android.os.Process.myPid());
        if (!LoadPluginUtil.getInstance(this).isLoadPlugin()) {
            Log.e(HostConstants.HOST_TAG, "宿主 service 还没有完成 插件加载:");
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(this, "com.didi.virtualapk.demo.service.MyService");
        startService(intent);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
