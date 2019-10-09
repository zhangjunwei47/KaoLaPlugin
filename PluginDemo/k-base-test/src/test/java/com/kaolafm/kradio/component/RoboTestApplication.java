package com.kaolafm.kradio.component;

import android.app.Application;
import com.kaolafm.kradio.lib.R;

/**
 * @author Donald Yan
 * @date 2019-07-02
 */
public class RoboTestApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        setTheme(R.style.Theme_AppCompat_DayNight_DarkActionBar);
        System.out.println("初始化");
        ComponentClient.init(this);
        ComponentManager.registerComponent(new TestAComponent());
        ComponentManager.registerComponent(new TestBComponent());

    }
}
