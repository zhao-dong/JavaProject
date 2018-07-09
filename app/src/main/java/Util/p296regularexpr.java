package Util;

/**
 * Created by dong.zhao on 2018/2/20.
 */

public class p296regularexpr {

    public static void main(String[] args)
    {
        System.out.println("-1234".matches("-?\\d+"));
        System.out.println("\\".matches("\\\\"));

        String str1="zhangsan.\tlisi.wangwu";
        //String str2 ="testString\\\\";
        //System.out.println(str2);
        System.out.println(str1);
        //String reg1="\\.";
        //直接用.不行，代表正则表达式的任意字符，
        // 用\.则是(在java意义上)转义了.无意义(非法)，
        // 所以用\转义一下\(变成正则意义上的转义字符？)，所以用\\.表示用.切割！

        String reg1 = "\t";
        splitDemo(str1,reg1);

    }


    public static void splitDemo(String str,String reg)
    {

        String[] arr=str.split(reg);

        for(String s:arr)
        {
            System.out.println(s);
        }

    }


}
