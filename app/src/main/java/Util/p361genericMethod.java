package Util;

/**
 * Created by dong.zhao on 2017/12/9.
 */

public class p361genericMethod {
    public <T> void f(T x)
    {
        System.out.println(x.getClass().getSimpleName());
    }
    public <T> void f2(T x) {
        System.out.println(x.getClass().getSimpleName());
    }

    public static void main(String[] args)
    {
        p361genericMethod p = new p361genericMethod();
        p.f("");
        p.f(1);
        p.f2(1.1f);
        p.f(p);
    }
}
