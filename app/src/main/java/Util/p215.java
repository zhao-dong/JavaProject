package Util;

/**
 * Created by dong.zhao on 2018/2/12.
 */

interface Counter {
    int next();
}

public class p215 {

    public Counter getCounter()
    {
        class LocalCounter implements Counter {
            @Override
            public int next() {
                return 0;
            }
        }
        return new LocalCounter();
    }


    public Counter getCounter2()
    {
        return new Counter() {
            @Override
            public int next() {
                return 0;
            }
        };
    }

    static class xxx{}

}
