package Util;

import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2017/11/1.
 */

public class DaemonFromFactory implements Runnable{
    public void run() {
        try {
            while(true)
            {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " + this);
            }
        } catch(InterruptedException e) {
            System.out.println("Interrupted");
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i = 0; i < 10; i++)
            exec.execute(new DaemonFromFactory());
        System.out.println("All daemons started");

        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main exits");
    }

}


class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}