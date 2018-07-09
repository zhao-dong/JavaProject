package Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dong.zhao on 2018/1/18.
 */


//运用共享技术有效地支持大量细粒度的对象。
//运用共享技术有效地支持大量细粒度的对象。
//运用共享技术有效地支持大量细粒度的对象。
//运用共享技术有效地支持大量细粒度的对象。
//运用共享技术有效地支持大量细粒度的对象。
//运用共享技术有效地支持大量细粒度的对象。

//get得不到再产生///

interface FlyweightInterface {
    void action(int arg);
}

class FlyweightImpl implements FlyweightInterface {

    public void action(int arg) {
        // TODO Auto-generated method stub
        System.out.println("参数值: " + arg);
    }
}



class FlyweightFactory {

    private static Map flyweights = new HashMap();

    public FlyweightFactory(String arg) {
        flyweights.put(arg, new FlyweightImpl());
    }

    public static FlyweightImpl getFlyweight(String key) {
        if (flyweights.get(key) == null) {
            flyweights.put(key, new FlyweightImpl());
        }
        return (FlyweightImpl) flyweights.get(key);
    }

    public static int getSize() {
        return flyweights.size();
    }
}


public class FlyWeightModel {

    public static void main(String[] args) {


        FlyweightImpl fly1 = FlyweightFactory.getFlyweight("a");
        fly1.action(1);

        FlyweightImpl fly2 = FlyweightFactory.getFlyweight("a");
        System.out.println(fly1 == fly2);

        FlyweightImpl fly3 = FlyweightFactory.getFlyweight("b");
        fly3.action(2);

        FlyweightImpl fly4 = FlyweightFactory.getFlyweight("c");
        fly4.action(3);

        FlyweightImpl fly5 = FlyweightFactory.getFlyweight("d");
        fly4.action(4);

        System.out.println(FlyweightFactory.getSize());

   }
}
