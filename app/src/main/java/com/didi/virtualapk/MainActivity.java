package com.didi.virtualapk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.didi.virtualapk.util.PermissionManager;

import java.io.File;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    private static final int PERMISSION_REQUEST_CODE_STORAGE = 20171222;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (!hasPermission()) {
            requestPermission();
        }
    }

    private void requestPermission() {
        PermissionManager.getInstance().requestPermission(this, new Subscriber() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Object o) {

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }


    private boolean hasPermission() {
        return PermissionManager.getInstance().isGrant(this);
    }


    public void onButtonClick(View v) {
        if (v.getId() == R.id.button) {
            if (!hasPermission()) {
                requestPermission();
                return;
            }
            if (isLoadPlugin()) {
                return;
            }
            loadPlugin(this);
        } else if (v.getId() == R.id.about) {
            if (!hasPermission()) {
                requestPermission();
                return;
            }

            if (!isLoadPlugin()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(this, "com.didi.virtualapk.demo.MainActivity");
            startActivity(intent);
        }
    }

    private boolean isLoadPlugin() {
        final String pkg = "com.didi.virtualapk.demo";
        if (PluginManager.getInstance(this).getLoadedPlugin(pkg) == null) {
            Toast.makeText(this, "plugin [com.didi.virtualapk.demo] not loaded", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void loadPlugin(Context base) {
        if (!Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            Toast.makeText(this, "sdcard was NOT MOUNTED!", Toast.LENGTH_SHORT).show();
        }
        PluginManager pluginManager = PluginManager.getInstance(base);
        File apk = new File(Environment.getExternalStorageDirectory(), "Test.apk");
        if (apk.exists()) {
            try {
                pluginManager.loadPlugin(apk);
                Log.i(TAG, "Loaded plugin from apk: " + apk);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                File file = new File(base.getFilesDir(), "Test.apk");
                java.io.InputStream inputStream = base.getAssets().open("Test.apk", 2);
                java.io.FileOutputStream outputStream = new java.io.FileOutputStream(file);
                byte[] buf = new byte[1024];
                int len;

                while ((len = inputStream.read(buf)) > 0) {
                    outputStream.write(buf, 0, len);
                }

                outputStream.close();
                inputStream.close();
                pluginManager.loadPlugin(file);
                Log.i(TAG, "Loaded plugin from assets: " + file);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
