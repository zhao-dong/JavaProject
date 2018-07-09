package Util;

/**
 * Created by dong.zhao on 2018/1/19.
 */

public class p269ExceptionSilencer {

    public static void main(String[] args)
    {
        try {
            throw new RuntimeException();
        }
        finally
        {
            return ;
        }
    }
}
