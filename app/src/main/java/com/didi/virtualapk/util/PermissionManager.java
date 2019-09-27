package com.didi.virtualapk.util;

import android.app.Activity;
import android.content.Context;

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
}
