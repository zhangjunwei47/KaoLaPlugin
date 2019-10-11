package com.didi.virtualapk;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.didi.virtualapk.util.HostConstants;
import com.didi.virtualapk.util.LoadPluginUtil;
import com.didi.virtualapk.util.PermissionManager;

/**
 * Created by renyugang on 16/8/10.
 */
public class VAApplication extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        PluginManager.getInstance(base).init();
        Log.e(HostConstants.HOST_TAG, "宿主 application 启动 id= "+  android.os.Process.myPid());
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (PermissionManager.getInstance().isHasWriteStoragePermission(getApplicationContext())) {
            Log.e(HostConstants.HOST_TAG,"application 有权限. 开始加载插件");
            LoadPluginUtil.getInstance(getApplicationContext()).loadPlugin();
        }
    }
}
