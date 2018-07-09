package Util;

import java.util.Formatter;
import java.util.FormatterClosedException;

/**
 * Created by dong.zhao on 2018/2/14.
 */

public class p290format {

    public static void main(String[] args)
    {
        int x = 5;
        float y = 9.0000000f;

        System.out.format("This string is %d:%f", x,y);

        Formatter f = new Formatter(System.out);
        f.format("\n%s %d:%f", "Formatter class ", x, y);

        System.out.println(String.format("String.format: %d, %f", x,y));


        System.out.println("aaa\nbbb");

        System.out.println("aaa"+"\r"+"bbb");
        System.out.println("aaa"+"\f"+"bbb");
    }
}
