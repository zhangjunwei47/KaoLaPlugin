package com.didi.virtualapk.demo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.didi.virtualapk.demo.R;
import com.didi.virtualapk.demo.fragment.LauncherFragment;

import me.yokeyword.fragmentation.SupportActivity;


public class SecondActivity extends SupportActivity {
    private static final String TAG = "SecondActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        loadRootFragment(R.id.launcher_root_content, LauncherFragment.getInstance(), false, false);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(TAG, "onNewIntent");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

}
