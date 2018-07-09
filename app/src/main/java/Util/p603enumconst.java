package Util;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by dong.zhao on 2018/1/24.
 */

public enum p603enumconst {

    DATE_TIME {
        String getInfo()
        {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        String getInfo()
        {
            return System.getenv("CLASSPATH");
        }
    },
    VERSION {
        String getInfo()
        {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();

    public static void main(String[] args)
    {
        for(p603enumconst csm: values())
            System.out.println(csm.getInfo());
    }
}
