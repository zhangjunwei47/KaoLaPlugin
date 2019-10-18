package com.kaolafm.module.util;

import android.content.res.Configuration;

import com.kaolafm.test.R;

public class TestUtil {
    public static int getGlobalPaddingLeft(int orientation) {
        int padding;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            padding = R.dimen.x50;
        } else {
            padding = R.dimen.x100;
        }
        return padding;
    }
}
