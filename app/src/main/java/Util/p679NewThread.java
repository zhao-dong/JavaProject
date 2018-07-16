package Util;

abstract class TestClass
{
    public void f()
    {
        System.out.println("in f()");
    }

    public abstract void g();

    public void h()
    {
        System.out.println("in h()");
    }
}

class TestClass2
{
    {System.out.println("in TestClase2");}
}

public class p679NewThread {

    public static void main(String[] args)
    {
        new TestClass() {

            {
                f();
                System.out.println("test code");
            }

            @Override
            public void g() {
                System.out.println("in g()");
            }
        }.g();

        new TestClass2();
    }
}
