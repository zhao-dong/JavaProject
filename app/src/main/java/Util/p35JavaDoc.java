package Util;

import java.util.Date;

/**
 * Created by dong.zhao on 2018/1/29. hehehha
 * @author zhaodong@motorolasolutions.com
 * @version 4.0
 * @param input is null
 */

public class p35JavaDoc {
    /** Entry point to class & application
     * @param args array of string arguments
     * @throws exceptions No exceptions thrown
     * @author zhaodong@solutions.com
     * @version this is 5.0
     */
    public static void main(String[] args)
    {
        System.out.println("Hello, it's ");
        System.out.println(new Date());
    }

    /** Hello world javadoc
     * @author zhaodong @ motorola solutions
     * @return returns the number of cases
     * @version this is version 4
     * @param  input paramters
     * @since java 7.0
     * @deprecated
     */
    public int func1(int input)
    {
        int i ;
        i = input;
        return i;
    }

    /** Hello world javadoc
     * @author zhaodong @ motorola solutions
     * @return returns the number of cases
     * @version this is version 4
     * @param  input paramters
     * @since java 6.0
     * @deprecated
     */
    protected int func2(int input) {
        int i;
        i = input;
        return i;
    }
}
