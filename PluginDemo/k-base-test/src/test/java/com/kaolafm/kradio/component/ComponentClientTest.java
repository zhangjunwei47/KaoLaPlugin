package com.kaolafm.kradio.component;

import org.junit.*;
import org.junit.runner.*;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * @author Donald Yan
 * @date 2019-07-01
 */
@RunWith(RobolectricTestRunner.class)
@Config(application = RoboTestApplication.class)
public class ComponentClientTest {
    @Test
    public void test() {
        Robolectric.setupActivity(TestActivity.class);

        ComponentResult result = ComponentClient.obtainBuilder("TestBComponent")
                .setActionName("getUserInfo").build().call();
        System.out.println("B-result="+result);

//        try {
//            Thread.currentThread().join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}

