package Util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2018/1/17.
 */

public class p730ScheduleThreadPoolExe {

    public static void main(String[] args) throws InterruptedException {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(1);
        for (int i = 0; i < 5; i ++){
            final int temp = i + 1;
            pool.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第"+temp+"个炸弹爆炸时间:" + simpleDateFormat.format(new Date()));

                }
            }, temp * 5, TimeUnit.SECONDS);
        }
        pool.shutdown();
        System.out.println("end main时间:" + simpleDateFormat.format(new Date()));
    }
}
