package DesignPattern.Proxy;

/**
 * Created by dong.zhao on 2018/4/18.
 */

abstract class Subject
{
    abstract public void Request();
}

class RealSubject extends Subject
{
    @Override
    public void Request() {
        System.out.println("真实的请求。");
    }
}

class Proxy extends Subject
{
    private Subject realSubject;

    @Override
    public void Request() {

        if(realSubject == null)
        {
            realSubject = new RealSubject();
        }
        realSubject.Request();
    }
}

public class exam8 {

    public static void main(String[] args)
    {
        Proxy proxy = new Proxy();
        proxy.Request();
    }
}
