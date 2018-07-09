package Util;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by dong.zhao on 2018/1/24.
 */

public class p596Enums {
    private static Random rand = new Random(47);
    public static <T extends Enum<T>> T random(Class<T> ec)
    {
        System.out.println(Arrays.toString(ec.getEnumConstants()));
        return random(ec.getEnumConstants());
    }
    public static <T> T random(T[] values)
    {
        return values[rand.nextInt(values.length)];
    }
}


