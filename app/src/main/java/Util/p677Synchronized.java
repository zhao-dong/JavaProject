package Util;


public class p677Synchronized {

    private static final String TAG = "p677Synchronized ";

    private void LOGD(String str1, String str2)
    {
        System.out.println(str1 + str2);
    }

    synchronized public void f() {
        LOGD(TAG, "f: ");
        g();
    }

    synchronized  public void g()
    {
        LOGD(TAG, "g: ");

    }


    public static void main(String[] args)
    {
        p677Synchronized p677 = new p677Synchronized();
        p677.f();
        System.out.println("exit from main");
    }
}
