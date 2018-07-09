package Util;

import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2017/11/29.
 */




public class item66 {

    //private static boolean stopRequested;
    private static volatile boolean stopRequested;

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }

    public static void main  (String[] args) throws InterruptedException {

        Thread backgroundTest = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while(!stopRequested)
                //while(!isStopRequested())
                    i++;
                System.out.println("Background thread exit!");
            }
        });
        backgroundTest.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
        //requestStop();
        System.out.println("set stopRequested as true in main thread");
    }
}
