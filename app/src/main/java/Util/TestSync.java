package Util;

/**
 * Created by dong.zhao on 2017/12/1.
 */

public class TestSync {

    private int i = 0;

    public synchronized  void  myAdd() {
        i++; i++;
        myDel();
    }

    public synchronized void  myDel() {
        i--;i--;
    }


    public static void main(String[] args) {

        TestSync ts = new TestSync();
        ts.myAdd();

    }
}
