package Util;

/**
 * Created by dong.zhao on 2017/12/3.
 */

class Base {
    private String name;

    protected void set(String nm)
    {
        name = nm;
    }
    public Base(String name) {
        this.name = name;
    }

    private void cb(String nm)
    {
        name = nm;
    }
    @Override
    public String toString() {
        return "This is base class " + name;
    }
}

class Derived extends Base
{
    private int number;
    public Derived(String name, int number)
    {
        super(name);
        this.number = number;
    }
    public void change(String name, int number) {
        set(name);
        //super.cb(name);
        this.number = number;
    }

    @Override
    public String toString() {
        return super.toString() + " number is " + number;
    }
}

public class P138Protected {

    static public void main(String[] args)
    {
        Derived de = new Derived("First Name", 12);
        System.out.println(de);
        de.change("Second Namme", 15);
        System.out.println(de);
    }

}
