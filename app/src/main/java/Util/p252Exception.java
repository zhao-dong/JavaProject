package Util;

/**
 * Created by dong.zhao on 2018/1/19.
 */

class MyException extends Exception {
    MyException(String msg) { super(msg);}
}


public class p252Exception {

    public static void f() throws MyException
    {
        System.out.println("Throwing MyException from f()");
        throw new MyException("Originated in f()");
    }

    public static void main(String[] args)
    {
        try {
            f();
        } catch(MyException e)
        {
            e.printStackTrace(System.err);
        }
    }

}
