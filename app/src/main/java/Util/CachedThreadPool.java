package Util;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dong.zhao on 2017/10/31.
 */

/*class LiftOff implements Runnable {

    protected int countDown = 100;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown: "Liftoff!") + "), ";
    }

    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}
*/

public class CachedThreadPool {

    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i< 5; i++ )//Thread t = new Thread(new LiftOff());
        {
            exec.execute(new LiftOff());
        }
        System.out.println("Waiting for LiftOff");
        exec.shutdown();
        System.out.println("After shutdown");
    }
}
