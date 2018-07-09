package Util;

/**
 * Created by dong.zhao on 2018/1/20.
 */

interface iInstrument {
    int VALUE = 5;
    void play();
}

public class p173interface implements iInstrument {

    @Override
    public void play() {

    }

    public static void main(String[] args)
    {
        System.out.println(VALUE);
        //VALUE = 10;
    }
}
