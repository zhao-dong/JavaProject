package Util;

import android.util.Log;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2017/12/2.
 * https://www.cnblogs.com/wxgblogs/p/5464867.html
 */


//An unbounded blocking queue of Delayed elements, in which an element can only be taken when its
// delay has expired. The head of the queue is that Delayed element whose delay expired furthest in the past.
// If no delay has expired there is no head and poll will return null.
// Expiration occurs when an element's getDelay(TimeUnit.NANOSECONDS) method returns a value less than or equal to zero.
// Even though unexpired elements cannot be removed using take or poll, they are otherwise treated as normal elements.
// For example, the size method returns the count of both expired and unexpired elements.
// This queue does not permit null elements.


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
            //thread 构造函数可以给一个Runnable参数
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
                //Retrieves and removes the head of this queue, or returns null
                //if this queue has no elements with an expired delay.
                if (delayEvent != null) {
                    counter++;
                }
            } while (delayEvent != null);
            System.out.println("At " + new Date() + " you have read " + counter+ " event");
            TimeUnit.MILLISECONDS.sleep(500);
        } while (queue.size() > 0);
        //size() Returns the number of elements in this collection.
    }
}
