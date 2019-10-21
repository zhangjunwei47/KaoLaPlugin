package com.kaolafm.module.util;

import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.TextView;

import com.kaolafm.module.base.R;

public class TestUtilModule {
    public static int getGlobalPaddingLeft(int orientation) {
        int padding;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            padding = R.dimen.x50;
        } else {
            padding = R.dimen.x100;
        }
        return padding;
    }


    @RequiresApi(api = Build.VERSION_CODES.M)
    public static void setStyle(TextView textView) {
        textView.setTextAppearance(R.style.HomeBack);
    }
}
