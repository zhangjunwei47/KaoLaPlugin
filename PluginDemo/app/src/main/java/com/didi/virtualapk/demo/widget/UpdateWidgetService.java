package com.didi.virtualapk.demo.widget;

import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.RemoteViews;

import com.didi.virtualapk.demo.R;
import com.didi.virtualapk.demo.utils.MyConstants;

public class UpdateWidgetService extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mHandler.sendEmptyMessageDelayed(1, 5000);
        return super.onStartCommand(intent, flags, startId);
    }

    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            update();
        }
    };


    public void update() {
        Context context = getApplicationContext();
        AppWidgetManager am = AppWidgetManager.getInstance(context);

        RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget_info_real);
        if (remoteViews == null) {
            Log.e(MyConstants.PLUGIN_TAG, "update view is null");
        } else {
            Log.e(MyConstants.PLUGIN_TAG, "update view is not null");
            //remoteViews.setImageViewResource(R.id.widgetIv, R.drawable.ic_plugin);
            remoteViews.setTextViewText(R.id.widgetTv, "你好吗?");
           // ComponentName name = new ComponentName(context, KaoLaWidget.class);
            ComponentName name = new ComponentName(context, "com.didi.virtualapk.demo.widget.KaoLaWidget");
            am.updateAppWidget(name, remoteViews);
        }
    }
}
