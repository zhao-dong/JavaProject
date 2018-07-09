package JUnitExample;

/**
 * Created by dong.zhao on 2018/2/4.
 */

public class Calculator {

    private int mSum;

    public int add(int one, int another)
    {
        mSum = one + another;
        return mSum;
    }

    public int div(int one, int another)
    {
        return one/another;
    }
}
