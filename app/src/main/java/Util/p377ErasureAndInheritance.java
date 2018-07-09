package Util;

/**
 * Created by dong.zhao on 2018/2/24.
 */

class GenericBase<T>
{
    private T element;
    public void set(T tag)
    {
        element = tag;
        //System.out.println("get set" + element.getClass().getSimpleName());
    }
    public T get()
    {
        //System.out.println("in get" + element.getClass().getSimpleName());
        return element;
    }
}

class Derived1<T> extends GenericBase<T> {}
class Derived2 extends GenericBase{}
//!class Derived3 extends GenericBase<?> {}

public class p377ErasureAndInheritance {

    public static void main(String[] args)
    {
        Derived2 d2 = new Derived2();
        Object obj = d2.get();
        d2.set(obj);

    }
}
