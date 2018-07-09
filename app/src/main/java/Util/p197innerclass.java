package Util;

/**
 * Created by dong.zhao on 2018/2/11.
 */

class Wrapping {
    private int i;
    public Wrapping(int x) { i = x;}
    public int value() { return i;}
}

public class p197innerclass {

    public Wrapping wrapping(int x)
    {
        return new Wrapping(x) {
            @Override
            public int value()
            {
                return 10 + super.value();
            }
        };
    }

    public static void main(String[] args)
    {
        p197innerclass p = new p197innerclass();
        Wrapping wrapping = p.wrapping(199);
        System.out.println(wrapping.value());
    }

}
