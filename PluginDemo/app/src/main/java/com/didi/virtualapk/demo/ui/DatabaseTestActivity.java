package com.didi.virtualapk.demo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.didi.virtualapk.demo.R;
import com.didi.virtualapk.demo.database.ConfigDBHelper;
import com.didi.virtualapk.demo.database.ConfigData;

public class DatabaseTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);
        init();
    }

    private void init() {
        findViewById(R.id.initBtn).setOnClickListener(v -> {
            ConfigDBHelper.getInstance(getApplicationContext()).init();
        });

        findViewById(R.id.readBtn).setOnClickListener(v -> {
            ConfigDBHelper.getInstance(getApplicationContext()).read("10").subscribe(configData -> {
                if (configData != null) {
                    Toast.makeText(DatabaseTestActivity.this, "读取数据库成功: " + configData.getJson(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(DatabaseTestActivity.this, "读取数据库成功, 数据为空 ", Toast.LENGTH_LONG).show();
                }
            });
        });

        findViewById(R.id.writeBtn).setOnClickListener(v -> {
            ConfigData configData = new ConfigData();
            configData.setId(1L);
            configData.setType(10);
            configData.setJson("哈哈哈哈哈哈哈哈哈");
            ConfigDBHelper.getInstance(getApplicationContext()).insertData(configData).subscribe(aLong -> {
                Log.e("logx", "xxxxxxxx 出入数据库成功");
            });
        });
    }
}
