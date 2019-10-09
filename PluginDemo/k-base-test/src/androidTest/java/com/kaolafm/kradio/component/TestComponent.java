package com.kaolafm.kradio.component;

/**
 * @author Donald Yan
 * @date 2019-07-01
 */
public class TestComponent implements Component {

    @Override
    public boolean onCall(RealCaller caller) {
        return false;
    }
}
