package Util;

/**
 * Created by dong.zhao on 2018/1/19.
 */

class BaseballException extends Exception {}
class Foul extends BaseballException {}
class Strike extends BaseballException {}

abstract class Inning {
    public Inning() throws BaseballException {}
    public void event() throws BaseballException {}
    public abstract void atBat() throws Strike, Foul;
    public void walk() {}
}

class StormException extends Exception {}
class RainOut extends StormException {}
class PopFoul extends Foul {}

interface Storm {
    public void event() throws RainOut;
    public void rainHard() throws RainOut;
}


public class p269ExceptionLimitation extends Inning implements Storm {

    public p269ExceptionLimitation() throws RainOut,BaseballException{}
    public p269ExceptionLimitation(String s) throws Foul, BaseballException {}

    public void rainHard() throws RainOut {}
    public void event() {}
    public void atBat() throws PopFoul {}

    public static void main(String[] args)
    {

        try
        {
            p269ExceptionLimitation si = new p269ExceptionLimitation();
            si.atBat();
        } catch(PopFoul e)
        {
            System.out.println("Pop foul");
        } catch(RainOut e)
        {
            System.out.println("Rained out");
        } catch(BaseballException e)
        {
            System.out.println("Generic baseball exception");
        }

    }


}
