package Util;

public class StringSplit {

    public static void main(String[] args)
    {

        String str = "hello;world;big;;";
        String[] test = str.split(";");
        for(int i = 0; i< test.length; i++) {
            System.out.println(test[i]);
        }
    }
}
