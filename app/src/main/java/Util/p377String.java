package Util;

import java.util.Random;

/**
 * Created by dong.zhao on 2017/9/30.
 */

public class p377String {
    public static String upcase(String  s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";
        System.out.println(q);
        String qq = upcase(q);
        System.out.println(qq);
        q.toUpperCase();
        System.out.println(q);
    }
}



