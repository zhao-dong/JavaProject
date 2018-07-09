package Util;

import static Util.p71LabeledFor.print;

/**
 * Created by dong.zhao on 2018/2/5.
 */

public class p73LabeledWhile {

    public static void main(String[] arg)
    {
        int i = 0;
        outer:
        while(true)
        {
            print("Outer while loop");
            while(true)
            {
                i++;
                print("i = " + i);

                if(i == 5)
                {
                    print("break;");
                    break;
                }
                if(i == 7)
                {
                    print("break outer");
                    break outer;
                }
            }
        }
    }
}
