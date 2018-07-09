package Util;

/**
 * Created by dong.zhao on 2018/2/24.
 */

public class p354GenericClass <T> {

    private T a;
    public void setA(T a1)
    {
        a = a1;
    }
    public T getA()
    {
        return a;
    }

    public static void main(String[] args)
    {
        p354GenericClass<String> p = new p354GenericClass<String>();
        p.setA("hello world");
        System.out.println(p.getA());
    }

}
