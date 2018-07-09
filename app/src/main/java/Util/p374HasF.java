package Util;

/**
 * Created by dong.zhao on 2018/2/24.
 */

class HasF {
    public void f() { System.out.println("HasF.f()");}
}

class Manipulator<T> {

    private T obj;
    public Manipulator(T t)
    {
        obj = t;
    }
    public void manipulate() {
        //!obj.f();
    }

}

class Manipulator2<T extends HasF> {

    private T obj;
    public Manipulator2(T t)
    {
        obj = t;
    }
    public void manipulate() {
        obj.f();
    }

}


public class p374HasF {

    public static void main(String[] args)
    {
        HasF hf = new HasF();
        //Manipulator<HasF> manipulator = new Manipulator<HasF>(hf);
        //manipulator.manipulate();

        Manipulator2<HasF> manipulator = new Manipulator2<HasF>(hf);
        manipulator.manipulate();
    }
}
