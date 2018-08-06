//package Util;

package p393;

import java.util.ArrayList;
import java.util.List;

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}


public class p393Super {

    public static void writeTo(List<? super Apple> apples)
    {
        apples.add(new Apple());
        apples.add(new Jonathan());

        //can not compile
        //apples.add(new Fruit());
    }

    public static void main(String[] args)
    {
        writeTo(new ArrayList<>());
        System.out.println("hello world");
    }
}
