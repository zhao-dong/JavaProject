package Util;

/**
 * Created by dong.zhao on 2018/2/11.
 */

public class p191innerclass {

    class Contents {
        private int i = 11;
        public int value() { return i;}
    }

    public Contents contents() {
        return new Contents();
    }

    public static void main(String[] args)
    {
        p191innerclass p = new p191innerclass();
        p191innerclass pp = new p191innerclass();
        p191innerclass.Contents c = p.contents();
        System.out.println(c.value());
    }

}
