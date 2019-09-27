//package com.didi.virtualapk.util;
//
//import android.Manifest.permission;
//import android.app.Activity;
//import android.content.Context;
//import android.content.pm.PackageManager;
//import android.support.v4.content.ContextCompat;
//
//import com.tbruyelle.rxpermissions.RxPermissions;
//
//import rx.Subscriber;
//
//public class PermissionUtils {
//    public String[] perms;
//    public RxPermissions rxPermissions;
//
//    Context mContext;
//
//    //需要弹出权限对话框
//    public PermissionUtils(Activity ctx) {
//        mContext = ctx;
//        initPermissions();
//        rxPermissions = new RxPermissions((Activity) mContext);
//    }
//
//    //不需要弹出对话框，只校验权限，复用需要权限列表
//    public PermissionUtils(Context ctx) {
//        mContext = ctx;
//        initPermissions();
//    }
//
//    private void initPermissions() {
//        perms = new String[]{
//                permission.WRITE_EXTERNAL_STORAGE,
//                permission.READ_EXTERNAL_STORAGE,
//                permission.READ_PHONE_STATE,
//                permission.RECORD_AUDIO,
//                permission.ACCESS_FINE_LOCATION,
//                permission.ACCESS_COARSE_LOCATION,
//        };
//    }
//
//    public void requestPermission(Subscriber sub) {
//
////     区分是公版的权限还是比亚迪的权限
//
//        if (sub == null) {
//            sub = new Subscriber<Boolean>() {
//                @Override
//                public void onCompleted() {
//
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                }
//
//                @Override
//                public void onNext(Boolean granted) {
//                    if (granted) {
//                        // All requested permissions are granted
//
//                    } else {
//                        // At least one permission is denied
//                        getDialog();
//                    }
//                }
//            };
//        }
//
//        rxPermissions.request(perms).subscribe(sub);
//    }
//
//    static int dialogWhich = 0;
//
//    public void getDialog() {
////        String pacName = mContext.getApplicationInfo().packageName;
////
////        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
////        builder.setCancelable(false);
////        builder.setMessage(mContext.getResources().getString(R.string.permissions_app_tip));
////        builder.setTitle(mContext.getResources().getString(R.string.permissions_tip));
////        builder.setNegativeButton(mContext.getResources().getString(R.string.live_cancel_message), new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialog, int which) {
////                dialogWhich = which;
////            }
////        });
////        builder.setPositiveButton(mContext.getResources().getString(R.string.go_setpermission), new DialogInterface.OnClickListener() {
////            @Override
////            public void onClick(DialogInterface dialog, int which) {
////                dialogWhich = which;
////            }
////        });
////
////        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
////            @Override
////            public void onDismiss(DialogInterface dialog) {
////                switch (dialogWhich) {
////                    case DialogInterface.BUTTON_NEGATIVE: {
////
////                        break;
////                    }
////                    case DialogInterface.BUTTON_POSITIVE: {
////                        Uri packageURI = Uri.parse("package:" + pacName);
////                        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, packageURI);
////                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                        mContext.startActivity(intent);
////                        break;
////                    }
////                    default:
////                }
////                System.exit(0);
////            }
////        });
////        builder.create().show();
//    }
//
//
//    public boolean isGrant() {
//        int grantsize = 0;
//        for (int i = 0; i < perms.length; i++) {
//            boolean isgrant = checkPermission(mContext, perms[i]);
//            if (isgrant) {
//                grantsize = grantsize + 1;
//            }
//        }
//        if (grantsize == perms.length) {
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public static boolean checkPermission(Context context, String... permissions) {
//        for (String permission : permissions) {
//            int granted = ContextCompat.checkSelfPermission(context, permission);
//            if (granted != PackageManager.PERMISSION_GRANTED) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//}
