package Util;

import java.io.Serializable;

/**
 * Created by dong.zhao on 2017/11/22.
 */

public class QueuedMsg implements Serializable {

    private StringBuffer mStringBuffer;

    public QueuedMsg() {
        mStringBuffer = new StringBuffer();
    }

    public synchronized void AddString(String sb) {
        mStringBuffer.append(sb);
    }
    public synchronized String GetString()
    {

        if(mStringBuffer.length() > 0)
        {
            String retStr = mStringBuffer.toString();
            mStringBuffer.setLength(0);
            //System.out.println("StringBuffer length is " + mStringBuffer.length());
            return retStr;
        }
        else
        {
            return null;
        }
    }

    public static void main(String[] args)
    {

        QueuedMsg qm = new QueuedMsg();
        qm.AddString("helloworld");
        //System.out.println(qm.GetString());
        String str = qm.GetString();
        test(str);
        System.out.println(str);
        //System.out.println(str.length());
        //System.out.println(qm.GetString());

    }

    private static void test(String str)
    {
        System.out.println("In test " + str);
    }
}
