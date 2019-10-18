package com.kaolafm.kradio.component;

import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import com.kaolafm.kradio.component.ComponentClient.Builder;
import org.junit.*;
import org.junit.runner.*;

/**
 * @author Donald Yan
 * @date 2019-07-01
 */
@RunWith(AndroidJUnit4.class)
public class ComponentClientTest {

    @Before
    public void setUp() throws Exception {
    }


    @Test
    public void init() {
    }

    @Test
    public void obtainBuilder() {

    }

    @Test
    public void test() {
        ComponentManager.registerComponent(new TestComponent());
        Builder com = ComponentClient.obtainBuilder("TestComponent");
        Log.e("ComponentClientTest", "obtainBuilder: "+com);
    }
}