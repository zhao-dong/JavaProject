package Util;

/**
 * Created by dong.zhao on 2017/10/31.
 */
 class LiftOff implements Runnable {

    protected int countDown = 100;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff() {}
    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown: "Liftoff!") + "), ";
    }

    @Override
    public void run() {
        while(countDown-- > 0) {
            System.out.print(status());
            Thread.yield();
        }
    }
}


public class BasicThread {

    public static void main(String[] args) {

        for(int i = 0; i< 5; i++ )//Thread t = new Thread(new LiftOff());
        {
            new Thread(new LiftOff()).start();
        }
        System.out.println("Waiting for LiftOff");
    }
}
