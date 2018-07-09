package Util;

/**
 * Created by dong.zhao on 2018/1/20.
 */

abstract class Instrument {
    public abstract void play();
    public String what() { return "Instrument";}
}

abstract class Wind extends Instrument {

}

class Percussion extends Instrument {

    public void play() {

    }
}

public class p170AbstractClass {

    public static void main(String[] args)
    {

    }
}
