package com.didi.virtualapk.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.didi.virtualapk.demo.manager.UserManager;
import com.didi.virtualapk.demo.model.User;
import com.didi.virtualapk.demo.service.MyService;
//import com.didi.virtualapk.demo.ui.DatabaseTestActivity;
//import com.didi.virtualapk.demo.ui.PlayerActivity;
import com.didi.virtualapk.demo.ui.SecondActivity;
import com.didi.virtualapk.demo.utils.MyConstants;
import com.didi.virtualapk.demo.utils.MyUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainx);
        UserManager.sUserId = 2;
        findViewById(R.id.inLauncher).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
//        findViewById(R.id.inPlayer).setOnClickListener(v -> {
//            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, PlayerActivity.class);
//            startActivity(intent);
//        });
//        findViewById(R.id.testDatabase).setOnClickListener(v -> {
//            Intent intent = new Intent();
//            intent.setClass(MainActivity.this, DatabaseTestActivity.class);
//            startActivity(intent);
//        });

        findViewById(R.id.startService).setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, MyService.class);
            startService(intent);
        });
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    private void persistToFile() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                User user = new User(1, "hello world", false);
                File dir = new File(MyConstants.CHAPTER_2_PATH);
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                File cachedFile = new File(MyConstants.CACHE_FILE_PATH);
                ObjectOutputStream objectOutputStream = null;
                try {
                    objectOutputStream = new ObjectOutputStream(
                            new FileOutputStream(cachedFile));
                    objectOutputStream.writeObject(user);
                    Log.d(TAG, "persist user:" + user);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    MyUtils.close(objectOutputStream);
                }
            }
        }).start();
    }
}
