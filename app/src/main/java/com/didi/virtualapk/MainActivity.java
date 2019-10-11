package com.didi.virtualapk;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.didi.virtualapk.util.LoadPluginUtil;
import com.didi.virtualapk.util.PermissionManager;

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
            if (LoadPluginUtil.getInstance(this).isLoadPlugin()) {
                return;
            }
            LoadPluginUtil.getInstance(this).loadPlugin();
        } else if (v.getId() == R.id.about) {
            if (!hasPermission()) {
                requestPermission();
                return;
            }

            if (!LoadPluginUtil.getInstance(this).isLoadPlugin()) {
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(this, "com.didi.virtualapk.demo.MainActivity");
            startActivity(intent);
        }
    }

}
