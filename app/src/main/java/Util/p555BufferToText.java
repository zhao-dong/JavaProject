package Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dong.zhao on 2018/1/7.
 */

public class p555BufferToText {


    public static void main(String[] args) throws Exception
    {
        FileChannel fc = new FileOutputStream("data2.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("Some Text");
        fc.write(buff);
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
