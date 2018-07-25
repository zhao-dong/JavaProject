package Util;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * https://blog.csdn.net/liuchuanhong1/article/details/53539341
 *  读和读互不影响，读和写互斥，写和写互斥
 */



public class p762ReentrantReadWriteLock {

    ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    public void get(Thread thread) {
        lock.readLock().lock();
        try{
            System.out.println("start time:"+System.currentTimeMillis());
            for(int i=0; i<5; i++){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(thread.getName() + ":正在进行读操作……");
            }
            System.out.println(thread.getName() + ":读操作完毕！");
            System.out.println("end time:"+System.currentTimeMillis());
        }finally{
            lock.readLock().unlock();
        }
    }

    public static void main(String[] args) {
        final p762ReentrantReadWriteLock lock = new p762ReentrantReadWriteLock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.get(Thread.currentThread());
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.get(Thread.currentThread());
            }
        }).start();
    }


}
