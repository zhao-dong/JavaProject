package Util;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by dong.zhao on 2018/1/14.
 */

public class p232HashSet {

    public static void main(String[] args)
    {
        Set<String> set1 = new HashSet<String>();
        Collections.addAll(set1, "A B C D E F G".split(" "));
        System.out.println(set1);

        Set<String> set2 = new TreeSet<String>();
        Collections.addAll(set2, "B G".split(" "));
        System.out.println(set2);

        System.out.println(set1.containsAll(set2));
    }
}
