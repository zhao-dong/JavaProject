package Util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by dong.zhao on 2018/2/23.
 */

public class p305ReFlags {

    public static void main(String[] args)
    {
        Pattern p = Pattern.compile("^java", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(
          "java has regex\nJava has regex\n" +
                  "JAVA has pretty good regular expressions\n"
        );

        while(m.find())
        {
            System.out.println(m.group());
        }
    }
}
