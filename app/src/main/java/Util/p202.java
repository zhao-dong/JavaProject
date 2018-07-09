package Util;

/**
 * Created by dong.zhao on 2018/2/11.
 */
 interface p202interface {
    void howdy();

}

public class p202 implements p202interface {
    @Override
    public void howdy() {
        System.out.println("howdy;");
    }

    public static void main(String[] args)
    {
        p202 p = new p202();
        p.howdy();
    }
}
