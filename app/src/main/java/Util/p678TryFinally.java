package Util;

public class p678TryFinally {


    private void f1()
    {
        System.out.println("in f1()");
    }

    private void f2()
    {
        System.out.println("in f2()");
    }

    static public void main(String[] args)
    {
        p678TryFinally p = new p678TryFinally();

        try
        {
            p.f1();
            return ;
        }
        finally
        {
            p.f2();
        }
    }

}
