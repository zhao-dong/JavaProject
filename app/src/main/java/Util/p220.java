package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by dong.zhao on 2018/1/13.
 */

public class p220 {

    public static void main(String[] args)
    {
        Collection<Integer> collection = new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        for(Integer i: collection)
        {
            System.out.println(i);
        }

        test<String> mytest = new test<String>("Helloworld");
        mytest.print();
        test<Integer> test1 = new test<Integer>(100);
        test1.print();
        //test<int> test2 = new test<int>(100);
        //test2.print();
    }
}

class test <T>
{
    private T m;
    public test (T x) { m = x;}
    public void print()
    {
        System.out.println(m);
    }
}
