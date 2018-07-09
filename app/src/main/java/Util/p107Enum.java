package Util;

/**
 * Created by dong.zhao on 2018/1/23.
 */

enum EnumTest{
    NOT,
    MILD,
    MEDIUM,
    HOT,
    FLAMING
}

public class p107Enum {

    static public void main(String[] args)
    {

        for(EnumTest e : EnumTest.values()) {
            System.out.println(e.name());
            System.out.println(e);
        }
    }

}
