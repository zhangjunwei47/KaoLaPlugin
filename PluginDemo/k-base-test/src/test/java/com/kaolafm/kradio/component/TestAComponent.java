package com.kaolafm.kradio.component;

/**
 * @author Donald Yan
 * @date 2019-07-01
 */
public class TestAComponent implements Component {

    @Override
    public boolean onCall(RealCaller caller) {
        System.out.println("TestAComponent.caller="+caller.actionName());
        new GetDataRunnable(caller).start();
        return true;
    }

    class GetDataRunnable extends Thread {
        RealCaller mCaller;

        GetDataRunnable(RealCaller caller) {
            this.mCaller = caller;
        }

        @Override
        public void run() {
            int maxStep = 6;
            int step = 1;
            for (; step <= maxStep; step++) {
                //判断超时或取消状态
                if (mCaller.isStopped()) {
                    break;
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //仅在未中止时调用回调
            if (!mCaller.isStopped()) {
                ComponentClient.sendResult(mCaller.getCallId(), ComponentResult.success("networkdata", "data from network"));
            } else {
                System.out.println("get data from network stopped. step="+step);
            }
        }
    }
}
