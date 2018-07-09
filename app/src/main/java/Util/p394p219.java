package Util;

import android.support.annotation.IntegerRes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by dong.zhao on 2017/10/7.
 */

public class p394p219 {


    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>();
        for(int i =0; i < 10;  i++)
        {
            c.add(i);
        }
        for(Integer i:c )
            System.out.print(i+", ");


        Collection<Integer> collection =
                new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        Integer[]  moreInts = {6,7,8,9};
        collection.addAll(Arrays.asList(moreInts));

        Collections.addAll(collection, 11,12,13,14,15);
        Collections.addAll(collection,moreInts);

        System.out.println("\n");

        for(Integer x : collection)
            System.out.print(x+"; ");

        List<Integer> list = Arrays.asList(16,17,18,19);
        list.set(1,99);

        for(Integer x: list)
            System.out.println(x+"|");

        //list.add(21);
    }

}

