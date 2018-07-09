//package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dong.zhao on 2017/12/10.
 */

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

public class p391 {


    //case_4
    /*
    public static void writeTo(List<? super Apple> apples)
    {
        apples.add(new Apple());
        apples.add(new Jonathan());
        apples.add(new Fruit());
    }
    */

    public static void main(String[] args)
    {

        //case_1
        //Fruit[] fruits = new Apple[10];
        //fruits[0] = new Apple();
       // fruits[1] = new Jonathan();

        //try {
        //    fruits[0] = new Fruit();
        //} catch (Exception e)
        //{
        //    System.out.println(e);
        //}

        /* case_2 */
        /*
        List<? extends Fruit> flist = new ArrayList<Apple>();
        flist.add(new Apple());
        flist.add(null);
        Fruit f = flist.get(0);
        */

        //case_3
        /*
        List<? extends Fruit> flist = Arrays.asList(new Apple());
        Apple a = (Apple)flist.get(0);
        if(flist.contains(new Apple())) {
            System.out.println("flist.contains Apple");
            System.out.println("Index is " + flist.indexOf(new Apple()));
        }
        else
        {
            System.out.println("flist doesn't contain Apple");
        }
        */


    }
}

