package com.kaolafm.kradio.component;

/**
 * @author Donald Yan
 * @date 2019-07-04
 */
public class TestBComponent implements Component , MainThreadable {

    @Override
    public boolean onCall(RealCaller caller) {
        System.out.println("TestBComponent.caller=" + caller.actionName());
        return false;
    }

    @Override
    public Boolean shouldActionRunOnMainThread(String actionName, ComponentClient caller) {
        return Boolean.TRUE;
    }
}
