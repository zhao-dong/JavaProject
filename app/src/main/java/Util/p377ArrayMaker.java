package Util;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Created by dong.zhao on 2018/2/24.
 */

public class p377ArrayMaker<T> {
    private Class<T> kind;
    public p377ArrayMaker(Class<T> kind)  { this.kind = kind;}
    T[] create(int size)
    {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args)
    {
        p377ArrayMaker<String> stringp377ArrayMaker = new p377ArrayMaker<String>(String.class);
        String[] stringArray = stringp377ArrayMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
