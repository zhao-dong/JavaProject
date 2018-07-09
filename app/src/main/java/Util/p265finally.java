package Util;

/**
 * Created by dong.zhao on 2018/1/19.
 */


class Switch {
    static void PRINT(Object o) { System.out.println(o);}
    private boolean state = false;
    public boolean read() { return state; }
    public void on() { state = true; PRINT(this);}
    public void off() { state = false; PRINT(this);}
    public String toString() { return state ? "on" : "off";}
}

class OnOffException1 extends Exception {}
class OnOffException2 extends Exception {}

public class p265finally {
    private static Switch sw = new Switch();
    public static void f() throws OnOffException1, OnOffException2 {}

    public static void main(String[] args)
    {
        try {
            sw.on();
            f();
            sw.off();
        } catch(OnOffException1 e)
        {
            Switch.PRINT("OnOffException1");
            sw.off();
        } catch(OnOffException2 e)
        {
            Switch.PRINT("OnOffException2");
            sw.off();
        }
    }

}
