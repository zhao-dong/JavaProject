package Util;

import java.util.ArrayList;

/**
 * Created by dong.zhao on 2018/2/24.
 */

public class p372TypeErase {

    public static void main(String[] args)
    {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1.getSimpleName());
        System.out.println(c2.getSimpleName());
        System.out.println(c1==c2);
    }
}
