//package com.didi.virtualapk.demo.widget;
//
//import android.appwidget.AppWidgetManager;
//import android.appwidget.AppWidgetProvider;
//import android.content.Context;
//import android.content.Intent;
//
///**
// * 使用这种类覆盖方式不可以
// */
//public class KaoLaWidget extends AppWidgetProvider {
//
//    @Override
//    public void onReceive(Context context, Intent intent) {
//        super.onReceive(context, intent);
//    }
//
//    @Override
//    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
//        super.onUpdate(context, appWidgetManager, appWidgetIds);
//    }
//
//    @Override
//    public void onEnabled(Context context) {
//        super.onEnabled(context);
//        Intent intent = new Intent();
//        intent.setClassName(context, "com.didi.virtualapk.demo.widget.UpdateWidgetService");
//        context.startService(intent);
//    }
//
//    @Override
//    public void onDisabled(Context context) {
//        super.onDisabled(context);
//    }
//}
