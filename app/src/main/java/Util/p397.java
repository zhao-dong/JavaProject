package Util;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by dong.zhao on 2018/1/9.
 */

public class p397 {

        public static void main(String[] args) throws IOException {
            ArrayList<String> al = new ArrayList<String>();
            al.add("a");
            al.add("b");

            accept(al);
        }

        public static void accept(ArrayList<?> al){
            for(Object o: al)
                System.out.println(o);
        }

}
