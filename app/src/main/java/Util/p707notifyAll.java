package Util;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Blocker {

    synchronized void waitingCall()
    {
        try {
            while(!Thread.interrupted())
            {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        }
        catch (InterruptedException ex)
        {

        }
    }
    synchronized void prod() { notify();}
    synchronized void prodAll() { notifyAll();}
}

class Task implements Runnable {

    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}


public class p707notifyAll {

    static public void main(String[] args)
    {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++)
        {
            exec.execute(new Task());
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException ex)
        {

        }

        System.out.println("Before Calling Notify");
        Task.blocker.prod();
        System.out.println("After Calling Notify");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex)
        {

        }

        System.out.println("Before Calling Notify All");
        Task.blocker.prodAll();
        System.out.println("After Calling Notify All");

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException ex)
        {

        }
        exec.shutdownNow();

    }
}
