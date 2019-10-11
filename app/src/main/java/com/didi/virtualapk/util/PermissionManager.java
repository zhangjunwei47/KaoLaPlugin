package com.didi.virtualapk.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import rx.Subscriber;

public class PermissionManager {
    PermissionUtils mPermissionUtils;

    private static final class PermissionManagerUtilHolder {
        private static final PermissionManager INSTANCE = new PermissionManager();
    }

    public static PermissionManager getInstance() {
        return PermissionManagerUtilHolder.INSTANCE;
    }

    private PermissionManager() {
    }

    public boolean isGrant(Activity context) {
        if (mPermissionUtils == null) {
            mPermissionUtils = new PermissionUtils(context);
        }
        return mPermissionUtils.isGrant();
    }


    public void requestPermission(Activity context, Subscriber subscriber) {
        if (mPermissionUtils == null) {
            mPermissionUtils = new PermissionUtils(context);
        }
        mPermissionUtils.requestPermission(subscriber);
    }

    public boolean isHasWriteStoragePermission(Context context) {
        PackageManager pm = context.getPackageManager();
        return (PackageManager.PERMISSION_GRANTED ==
                pm.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", context.getPackageName()));
    }


}
