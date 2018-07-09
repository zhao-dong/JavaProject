package DesignPattern.Prototype;

/**
 * Created by dong.zhao on 2018/4/17.
 */


abstract class Prototype
{
    private String id;
    public Prototype(String id)
    {
        this.id = id;
    }
    abstract public Prototype Clone();
    String getId()
    {
        return id;
    }
}


class ConcreteProtype1 extends Prototype
{
    public ConcreteProtype1(String id)
    {
        super(id);
    }

    @Override
    public Prototype Clone() {
        Prototype p = new ConcreteProtype1(getId());
        return p;
    }
}

public class exam3 {

    static public void main(String[] args)
    {
        ConcreteProtype1 p1 = new ConcreteProtype1("Helloworld");
        ConcreteProtype1 p2 = (ConcreteProtype1)p1.Clone();
        System.out.println(p2.getId());
    }
}
