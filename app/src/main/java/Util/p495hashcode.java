package Util;

/**
 * Created by dong.zhao on 2018/1/18.
 */

public class p495hashcode {

    public static void main(String[] args)
    {
        String[] hellos = "hello hello".split(" ");
        System.out.println(hellos[0].hashCode());
        System.out.println(hellos[1].hashCode());
    }
}
