package Util;

import android.provider.Settings;
import android.renderscript.ScriptGroup;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2018/1/8
 */

class SleepBlocked implements Runnable {
    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(100);
        } catch(InterruptedException e)
        {
            System.out.println("InterruptedException");
        }
        System.out.println("Exiting SleepBlocked.run() ");
    }
}

class IOBlocked implements Runnable {
    private InputStream in;
    public IOBlocked(InputStream is ) { in = is;}
    public void run()
    {
        try {
            System.out.println("Waiting for read(): ");
            in.read();
        } catch (IOException e)
        {
            if(Thread.currentThread().isInterrupted())
            {
                System.out.println("Interrupted from blocked I/O");
            }
            else
            {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exiting IOBlocked.run()");
    }
}

public class p696Interrupting {

    private static ExecutorService exec = Executors.newCachedThreadPool();

    static void test(Runnable r) throws InterruptedException {
        Future<?> f = exec.submit(r);
        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println("Interrupting " + r.getClass().getName());
        f.cancel(true);
        System.out.println("Interrupt sent to " + r.getClass().getName());
    }

    public static void main(String[] args) throws Exception
    {
        //test(new SleepBlocked());
        ExecutorService exec = Executors.newCachedThreadPool();

        ServerSocket server = new ServerSocket(9999);
        InputStream socketInput = new Socket("localhost",9999).getInputStream();

        exec.execute(new IOBlocked(socketInput));
        TimeUnit.SECONDS.sleep(3);
        exec.shutdownNow();
        System.out.println("ShutdownNow");
        TimeUnit.SECONDS.sleep(3);
        //System.in.close();
        socketInput.close();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Aborting with System.exit(0) ");
        System.exit(0);
    }

}
