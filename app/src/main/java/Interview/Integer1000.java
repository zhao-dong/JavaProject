package Interview;

import java.lang.reflect.Field;

/**
 * Created by dong.zhao on 2018/2/19.
 */

public class Integer1000 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException
    {
        Integer aa = 1000, bb = 1000;
        System.out.println(aa == bb);//1
        Integer c = 100, d = 100;
        System.out.println(c == d);//2

        Class cache = Integer.class.getDeclaredClasses()[0]; //1
        Field myCache = cache.getDeclaredField("cache"); //2
        myCache.setAccessible(true);//3

        Integer[] newCache = (Integer[]) myCache.get(cache); //4
        newCache[132] = newCache[133]; //5

        int a = 2;
        int b = a + a;
        System.out.printf("%d + %d = %d", a, a, b); //


        Integer t1 = new Integer(10);
        Integer t2 = new Integer(10);
        Integer t3 = 10;
        Integer t4 = 10;


        System.out.println(t1 == t2);
        System.out.println(t3 == t4);
    }

}
