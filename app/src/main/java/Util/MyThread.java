package Util;

import java.io.File;
import java.util.Arrays;

/**
 * Created by dong.zhao on 2017/9/24.
 */

public class MyThread {

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("In Thread, Runnable");
            }
        }).start();
    }

}
