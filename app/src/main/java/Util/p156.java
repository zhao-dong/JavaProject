package Util;

/**
 * Created by dong.zhao on 2018/1/20.
 */

class p156base {
    //private   void f() { System.out.println("private f()");}
    protected   void f() { System.out.println("private f()");}
}

public class p156 extends p156base {
    public void g() {
        f(); //can't compile
    }
}
