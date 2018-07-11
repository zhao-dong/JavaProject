package Util;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ExceptionThread implements Runnable
{
    @Override
    public void run() {
        throw new RuntimeException();
    }
}

public class p672UncaughtException {

    public static void main(String[] args)
    {
        //try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        //}

    }
}
