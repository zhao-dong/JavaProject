package Util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by dong.zhao on 2018/1/19.
 */

public class p513Collections {

    static List<String> list = Arrays.asList("one Two three Four five six one".split(" "));

    static void PRINT(Object str)
    {
        System.out.println(str);
    }

    public static void main(String[] args)
    {
        PRINT(list);
        PRINT(Collections.singletonList("four"));
        PRINT("max " + Collections.max(list));
        PRINT("min " + Collections.min(list));

        PRINT("max w/ comparator" + Collections.max(list, String.CASE_INSENSITIVE_ORDER));
        PRINT("min w/ comparator" + Collections.min(list, String.CASE_INSENSITIVE_ORDER));

        List<String> subList = Arrays.asList("Four five six".split(" "));
        PRINT("index of subList " + Collections.indexOfSubList(list, subList));
        PRINT("lastIndexOfSubList" + Collections.lastIndexOfSubList(list, subList));

        Collections.replaceAll(list, "one", "Yo");
        PRINT("replaceAll: " + list);

        Collections.reverse(list);
        PRINT("reverse: " + list);

        Collections.rotate(list, 3);
        PRINT("rotate: " + list);

        List<String> source = Arrays.asList("in the matrix".split(" "));
        Collections.copy(list, source);
        PRINT("copy: " +list);

        Collections.swap(list, 0, list.size()-1);
        PRINT("swap: " + list);

        Collections.shuffle(list, new Random(47));
        PRINT("shuffled " + list);

        Collections.fill(list, "pop");
        PRINT("fill " + list);

        PRINT("frequency of 'pop: " + Collections.frequency(list, "pop"));

        List<String> dups = Collections.nCopies(3, "snap");
        PRINT("dups " + dups);

    }
}
