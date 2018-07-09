package Util;

import java.util.concurrent.TimeUnit;

/**
 * Created by dong.zhao on 2018/1/23.
 */

public class threadcallback {

    static private int test;

    static private void f(final int i)
    {
        test = i;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(i);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                System.out.println(test);
            }
        }).start();
    }

    static public void main(String[] args)
    {
        for(int i = 1; i < 5 ; i++)
        {
           f(i);
        }
        test = 10;
    }
}
