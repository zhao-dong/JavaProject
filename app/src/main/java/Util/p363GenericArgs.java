package Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong.zhao on 2017/12/10.
 */

public class p363GenericArgs {
    public static <T> List<T> makeList(T... args)
    {
        List<T> resulst = new ArrayList<T>();
        for(T item: args)
            resulst.add(item);
        return resulst;
    }

    public static void func(int... args)
    {
        System.out.println(args.getClass().getSimpleName());
        //args 的类型是 int[]
        for(int i : args)
            System.out.println(i);
    }

    public static void main(String[] args)
    {
        List<String> ls = makeList("A");
        System.out.println(ls);


        ls = makeList("A", "B", "C");
        System.out.println(ls);

        ls = makeList("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);

        func(1,2,2,3,4,4,4);

    }
}
