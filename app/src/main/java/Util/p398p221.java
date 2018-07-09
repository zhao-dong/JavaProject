package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by dong.zhao on 2017/10/7.
 */

class Snow {}
class Powder extends Snow {}
class Light extends Powder{}
class Heavy extends Powder{}
class Crusty extends Snow{}
class Slush extends Snow{}

public class p398p221 {


    public static void main(String[] args)
    {
        List<Snow> snow = Arrays.<Snow>asList(new Light(),new Heavy());

        List<Snow> snow2 =new ArrayList<Snow>();
        Collections.addAll(snow2, new Light(),new Heavy());
        System.out.println(snow2);


        //List<Integer> list = Arrays.asList(1,2,3,4,5,6);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Iterator<Integer> iterator = list.iterator();

        Integer i = iterator.next();
        //iterator.remove();
        System.out.println(i);
        while(iterator.hasNext()) {
            i = iterator.next();
            System.out.println(i);
        }

        ListIterator<Integer> i1 = list.listIterator(1);

        System.out.println(i1.next());

        System.out.println(i1.previous());

    }
}
