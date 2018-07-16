package Util;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Entrance implements Runnable {

    @Override
    public void run() {
        while(true)
        {
            System.out.println("in run!");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}

public class p693ShutDown {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        for (int i = 0; i < 2; i++) {
            exec.execute(new Entrance());
        }
        exec.shutdownNow();

        System.out.println("wait thread to exit" + exec.awaitTermination(15, TimeUnit.SECONDS));

    }
}
