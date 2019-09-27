//package com.didi.virtualapk.util;
//
//import android.content.Context;
//
//public class PermissionManager {
//    PermissionUtils mPermissionUtils;
//
//    private static final class PermissionManagerUtilHolder {
//        private static final PermissionManager INSTANCE = new PermissionManager();
//    }
//
//    public static PermissionManager getInstance() {
//        return PermissionManagerUtilHolder.INSTANCE;
//    }
//
//    private PermissionManager() {
//    }
//
//    public boolean isGrant(Context context) {
//        if (mPermissionUtils == null) {
//            mPermissionUtils = new PermissionUtils(context);
//        }
//        return mPermissionUtils.isGrant();
//    }
//}
