package Util;

/**
 * Created by dong.zhao on 2017/11/14.
 */

/**
 * 同步线程
 */
class SyncThread implements Runnable {

    private int count;

    public SyncThread() {
        count = 0;
    }

    public synchronized void countAdd() {
        //synchronized(this) {
            for (int i = 0; i < 5; i ++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        //}
    }

    //非synchronized代码块，未对count进行读写操作，所以可以不用synchronized
    public  void printCount() {
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + " count:" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        String threadName = Thread.currentThread().getName();
        if (threadName.equals("A")) {
            countAdd();
        } else if (threadName.equals("B")) {
            printCount();
        }
    }

    public static void main(String[] args) {
       // String threadName = Thread.currentThread().getName();
        SyncThread counter = new SyncThread();
        Thread thread1 = new Thread(counter, "A");
        Thread thread2 = new Thread(counter, "B");
        thread1.start();
        thread2.start();
    }


}