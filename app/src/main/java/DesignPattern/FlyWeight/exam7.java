package DesignPattern.FlyWeight;

import java.util.Hashtable;

/**
 * Created by dong.zhao on 2018/4/18.
 */

abstract class FlyWeight
{
    public abstract void Operation(int extrinsicstate);
}

class ConcreteFlyWeight extends FlyWeight
{
    @Override
    public void Operation(int extrinsicstate) {
        System.out.println("具体Flyweight：" + extrinsicstate);
    }
}

class UnsharedConcreteFlyWight extends FlyWeight
{
    @Override
    public void Operation(int extrinsicstate) {
        System.out.println("不共享的Flyweight：" + extrinsicstate);
    }
}

class FlyWeightFactory
{
    private Hashtable flyweights = new Hashtable<String, FlyWeight>();

    public FlyWeightFactory()
    {
        flyweights.put("X", new ConcreteFlyWeight());
        flyweights.put("Y", new ConcreteFlyWeight());
        flyweights.put("Z", new ConcreteFlyWeight());
    }

    public FlyWeight getFlyWeight(String key)
    {
        return (FlyWeight)flyweights.get(key);
    }
}

public class exam7 {

    public static void main(String[] args)
    {
        int extrinsicstate = 22;

        FlyWeightFactory f = new FlyWeightFactory();
        FlyWeight fx = f.getFlyWeight("X");
        fx.Operation(--extrinsicstate);

        FlyWeight fy = f.getFlyWeight("Y");
        fy.Operation(--extrinsicstate);
    }
}
