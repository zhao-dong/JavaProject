//package Util;


import java.util.concurrent.ExecutorService;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}


class Holder<T>
{
    private T value;
    public Holder() {}
    public Holder(T val) { value = val; }

    //set()方法不能工作于Apple或Fruit，因为set()的参数一是"? Extends Fruit"
    //这意味着它可以是如何事物，而编译器无法验证"任何事物"的类型安全性。
    public void set(T val) { value = val; }

    //get()，它只会返回一个Fruit-这就是在给定"任何扩展自Fruit的对象"这一边界以后
    //它所能知道的一切了。
    public T get() { return value ;}
    public boolean equals(Object obj)
    {
        return value.equals(obj);
    }
}

public class p392GenericHolder {


    public static void main(String[] args)
    {
        Holder<Apple> appleHolder = new Holder<>(new Apple());
        Apple d = appleHolder.get();
        appleHolder.set(d);

        //can not compile
        //Holder<Fruit> fruitHolder = appleHolder;

        Holder<? extends Fruit> fruitHolder = appleHolder;
        Fruit p = fruitHolder.get();
        d = (Apple)fruitHolder.get();

        try {
            Orange c = (Orange) fruitHolder.get();

        }catch (Exception ex)
        {
            System.out.println(ex);

           // fruitHolder.set(new Apple());
        }


    }
}
