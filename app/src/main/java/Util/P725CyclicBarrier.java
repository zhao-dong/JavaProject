package Util;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2017/12/2.
 */

public class P725CyclicBarrier {

    private static final int THREAD_NUM = 5;

    public static class WorkerThread implements Runnable{

        CyclicBarrier barrier;
        Random rd = new Random(10);

        public WorkerThread(CyclicBarrier b){
            this.barrier = b;
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            while(!Thread.interrupted()) {
                try {
                    System.out.println("Worker's waiting");
                    //线程在这里等待，直到所有线程都到达barrier。
                    barrier.await();
                    System.out.println("ID:" + Thread.currentThread().getId() + " Working");
                    try {
                        TimeUnit.SECONDS.sleep(rd.nextInt(3));
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                    System.out.println("ID:" + Thread.currentThread().getId() + " Working done");

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        CyclicBarrier cb = new CyclicBarrier(THREAD_NUM, new Runnable() {
            //当所有线程到达barrier时执行
            @Override
            public void run() {
                // TODO Auto-generated method stub
                System.out.println("Inside Barrier");
                try {
                    TimeUnit.SECONDS.sleep(30);
                } catch(Exception e)
                {
                    e.printStackTrace();
                }

            }
        });

        for(int i=0;i<THREAD_NUM;i++){
            new Thread(new WorkerThread(cb)).start();
        }
    }

}
/*
以下是输出：
Worker's waiting
Worker's waiting
Worker's waiting
Worker's waiting
Worker's waiting
Inside Barrier
ID:12 Working
ID:8 Working
ID:11 Working
ID:9 Working
ID:10 Working
*/