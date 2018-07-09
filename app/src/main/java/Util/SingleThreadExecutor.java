package Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dong.zhao on 2017/10/31.
 */

public class SingleThreadExecutor {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i< 5; i++ )//Thread t = new Thread(new LiftOff());
        {
            exec.execute(new LiftOff());
        }
        System.out.println("Waiting for LiftOff");
        exec.shutdown();
        System.out.println("After shutdown");
    }
}
