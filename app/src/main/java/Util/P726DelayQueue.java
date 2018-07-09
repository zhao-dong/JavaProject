package Util;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2017/12/2.
 * https://www.cnblogs.com/wxgblogs/p/5464867.html
 */


class DelayEvent implements Delayed {
    private Date startDate;
    public DelayEvent(Date startDate) {
        super();
        this.startDate = startDate;
    }
    @Override
    public int compareTo(Delayed o) {
        long result = this.getDelay(TimeUnit.NANOSECONDS)
                - o.getDelay(TimeUnit.NANOSECONDS);
        if (result < 0) {
            return -1;
        } else if (result > 0) {
            return 1;
        } else {
            return 0;
        }
    }
    @Override
    public long getDelay(TimeUnit unit) {
        Date now = new Date();
        long diff = startDate.getTime() - now.getTime();
        return unit.convert(diff, TimeUnit.MILLISECONDS);
    }
}

 class DelayTask implements Runnable {
    private int id;
    private DelayQueue<DelayEvent> queue;
    public DelayTask(int id, DelayQueue<DelayEvent> queue) {
        super();
        this.id = id;
        this.queue = queue;
    }
    @Override
    public void run() {
        Date now = new Date();
        Date delay = new Date();
        delay.setTime(now.getTime() + id * 10000);
        System.out.println("Thread " + id + " " + delay);
        for (int i = 0; i < 100; i++) {
            DelayEvent delayEvent = new DelayEvent(delay);
            queue.put(delayEvent);
        }
    }
}

public class P726DelayQueue {

    public static void main(String[] args) throws Exception {

        DelayQueue<DelayEvent> queue = new DelayQueue<DelayEvent>();
        Thread threads[] = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            DelayTask task = new DelayTask(i + 1, queue);
            threads[i] = new Thread(task);
        }
        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        do {
            int counter = 0;
            DelayEvent delayEvent;
            do {
                delayEvent = queue.poll();
                if (delayEvent != null) {
                    counter++;
                }
            } while (delayEvent != null);
            System.out.println("At " + new Date() + " you have read " + counter+ " event");
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size() > 0);
    }
}
