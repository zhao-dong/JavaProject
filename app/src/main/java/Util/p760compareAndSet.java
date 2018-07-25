package Util;

import java.util.concurrent.atomic.AtomicInteger;

public class p760compareAndSet {

    static private AtomicInteger atomicInteger;

    static public void main(String[] args)
    {
        atomicInteger = new AtomicInteger(0);

        for(int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 9; j++) {
                        atomicInteger.addAndGet(1);
                    }
                }
            }).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {

                boolean result = false;
                while(result == false)
                {
                    int i = atomicInteger.get();
                    System.out.println("initial i " + i);
                    result = atomicInteger.compareAndSet(i, 999);
                    System.out.println("result is " + result);
                    Thread.yield();
                }
            }
        }).start();
    }

}
