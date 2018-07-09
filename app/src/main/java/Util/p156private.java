package Util;

import static Util.p71LabeledFor.print;

/**
 * Created by dong.zhao on 2018/2/10.
 */

public class p156private {

    private void f() { print("private f()");}
    public int field = 0;
    public static void main(String[] args)
    {
        p156private p = new p156Derived();
        p.f();
    }
}

class p156Derived extends p156private
{
    public int field = 1;
    //@Override
    public void f() { print("public f()");}
}