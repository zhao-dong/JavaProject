package Util;

import android.util.Log;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2017/10/31.
 */

public class CallableDemo {
    public static void main(String[] args) {

        ExecutorService exec = Executors.newCachedThreadPool();

        ArrayList<Future<String>> results = new ArrayList<Future<String>>();

        for(int i = 0; i < 10; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for(Future<String> fs: results) {
            try {

                System.out.println("fs.isDone(): " + fs.isDone());

                if( fs.isDone()) {
                    System.out.println(fs.get());
                }
                else
                {
                    System.out.println("waiting for done!");
                    System.out.println(fs.get());
                }

            } catch(InterruptedException e) {
                System.out.println(e);
                return;
            } catch(ExecutionException e) {
                System.out.println(e);
            } finally {
                exec.shutdown();
                System.out.println("After exec.shoutdown");
            }
        }
    }
}

class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int id) {
        this.id = id;
    }
    public String call() {
        try {
            TimeUnit.SECONDS.sleep(4);
        }
        catch (InterruptedException ex)
        {

        }
        return "result of TaskWithResult " + id;
    }
}
