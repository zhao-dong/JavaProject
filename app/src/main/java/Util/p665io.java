package Util;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by dong.zhao on 2017/10/9.
 */

public class p665io {


    public static String read(String filename) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(filename));
        String s;
        StringBuilder sb = new StringBuilder();
        while( (s = in.readLine())!= null)
        {
            sb.append(s+"\n");
        }
        in.close();
        return sb.toString();
    }

    public static void parseXMLwWithPull(String xmlData) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(xmlData));

            int eventType = xmlPullParser.getEventType();
            String id="";
            String name="";
            String version="";
            while(eventType != xmlPullParser.END_DOCUMENT)
            {
                String nodeName = xmlPullParser.getName();
                switch(eventType)
                {
                    case XmlPullParser.START_TAG:
                        if("id".equals(nodeName))
                            id = xmlPullParser.nextText();
                        else if("name".equals(nodeName))
                            name = xmlPullParser.nextText();
                        else if("version".equals(nodeName))
                            version =xmlPullParser.nextText();
                        break;
                    case XmlPullParser.END_TAG:
                        if("app".equals(nodeName)) {
                            System.out.print("id is " + id + " name is " + name + " version is "+ version);
                        }
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        //System.out.print(read("test.xml"));
        parseXMLwWithPull(read("test.xml"));
    }
}
