package Util;

/**
 * Created by dong.zhao on 2018/1/20.
 */

class testexception extends Exception{}

public class p289Exception {

    public static void f() throws testexception {
    }

    public static void g() {
        throw new RuntimeException();
    }
    public static void h() {
        //throw new testexception(); //can't pass compilation
    }

    public static void main(String[] args)
    {
        try {
            f();
        } catch (testexception e)
        {
            e.printStackTrace();
        }
        g();
        h();
    }


}
