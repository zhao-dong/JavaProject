package Util;

import android.os.Build;
import android.util.Log;

public class StringBuilderAppend {

    public static String BuildGeneralTicketMsg(String UserName, String Password,String addInfo)
    {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("<tickets>");
        strBuilder.append("<username>");
        strBuilder.append(UserName);
        strBuilder.append("</username>");
        strBuilder.append("<id>");
        strBuilder.append("</id>");
        strBuilder.append(addInfo);
        strBuilder.append("</tickets>");
        return strBuilder.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(BuildGeneralTicketMsg("hello", "passworld", null));
    }
}
