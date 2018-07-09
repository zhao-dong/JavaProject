package Util;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by dong.zhao on 2017/8/30.
 */

public class DirList2 {

    public static void main(String[] args) {

        File path = new File(".");
        String[] list;
        //list = path.list();
        list = path.list(filter("gradlew.bat"));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }


    public static FilenameFilter filter (final String regex){

        //must be final, this is required by the anonymous inner class
        // so that it can use an object from outside its scope.
        return new FilenameFilter() {

            private Pattern pattern = Pattern.compile(regex);
            @Override
            public boolean accept(File file, String name) {
                return pattern.matcher(name).matches();
            }
        };
    }
}
