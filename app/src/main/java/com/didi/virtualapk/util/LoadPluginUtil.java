package com.didi.virtualapk.util;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import com.didi.virtualapk.PluginManager;


import java.io.File;

public class LoadPluginUtil {
    private Context mContext;
    private static volatile LoadPluginUtil mInstance;

    private LoadPluginUtil(Context context) {
        mContext = context;
    }

    public static LoadPluginUtil getInstance(Context context) {
        if (mInstance == null) {
            synchronized (LoadPluginUtil.class) {
                if (mInstance == null) {
                    mInstance = new LoadPluginUtil(context);
                }
            }
        }
        return mInstance;
    }


    public boolean isLoadPlugin() {
        final String pkg = "com.didi.virtualapk.demo";
        if (PluginManager.getInstance(mContext).getLoadedPlugin(pkg) == null) {
            return false;
        }
        return true;
    }

    public void loadPlugin() {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Toast.makeText(mContext, "sdcard was NOT MOUNTED!", Toast.LENGTH_SHORT).show();
        }
        PluginManager pluginManager = PluginManager.getInstance(mContext);
        File apk = new File(Environment.getExternalStorageDirectory(), "Test.apk");
        if (apk.exists()) {
            try {
                pluginManager.loadPlugin(apk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                File file = new File(mContext.getFilesDir(), "Test.apk");
                java.io.InputStream inputStream = mContext.getAssets().open("Test.apk", 2);
                java.io.FileOutputStream outputStream = new java.io.FileOutputStream(file);
                byte[] buf = new byte[1024];
                int len;

                while ((len = inputStream.read(buf)) > 0) {
                    outputStream.write(buf, 0, len);
                }

                outputStream.close();
                inputStream.close();
                pluginManager.loadPlugin(file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}

