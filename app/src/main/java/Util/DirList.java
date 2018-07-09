package Utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * Created by dong.zhao on 2017/8/30.
 */

public class DirList {
    public static void main(String[] args) {

        File path = new File(".");
        String[] list;
        //list = path.list();
        list = path.list(new DirFilter("gradlew.bat"));
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for(String dirItem : list)
            System.out.println(dirItem);
    }
    //TODO
    //(1).Need to review Strategy
    //(2).Need to know how to setting????check the book////
}

class DirFilter implements FilenameFilter {
    private Pattern pattern;
    public DirFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}