package Util;

import java.io.PrintStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dong.zhao on 2018/2/23.
 */

public class p301matcher {

    public static void main(String[] args)
    {
        Matcher m = Pattern.compile("\\w+").matcher("Evening is full of linent's wings");
        while(m.find())
            System.out.println(m.group() + " ");

    }
}
