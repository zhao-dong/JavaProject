package Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong.zhao on 2018/1/18.
 */

public class p472List {

    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i< 10; i++)
            list.add(i);
        System.out.println(list);
        List sub = list.subList(3,6);
        System.out.println(sub);
        System.out.println(list);
        sub.clear();
        System.out.println(list);
    }
}
