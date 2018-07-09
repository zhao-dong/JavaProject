package Util;

import java.security.Security;
import java.util.Arrays;

/**
 * Created by dong.zhao on 2018/1/24.
 */

public enum p599SecurityCategory {
    STOCK(Security.Stock.class),
    BOND(Security.Bond.class);
    public Security[] values;
    p599SecurityCategory(Class<? extends Security> kind)
    {
        values = kind.getEnumConstants();
    }
    public Security[] getValue()
    {
        return values;
    }


    interface Security {
        enum Stock implements Security { SHORT, LONG, MARGIN }
        enum Bond implements Security { MUNICIPAL, JUNK }
    }
    public static void main(String[] args)
    {
        for(int i = 0; i < 5; i++)
        {
            p599SecurityCategory test = p596Enums.random(p599SecurityCategory.class);
            System.out.println(Arrays.toString(test.getValue()));
        }
    }
}
