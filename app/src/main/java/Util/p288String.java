package Util;

/**
 * Created by dong.zhao on 2018/2/13.
 */

public class p288String {

    public static void main(String[] args)
    {
        char[] ch = {'a','b','c' };
        String str = new String(ch);
        System.out.println(str);
        try {

            byte[] b = str.getBytes("unicode");

            for(byte x : b)
                System.out.println(x);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

}
