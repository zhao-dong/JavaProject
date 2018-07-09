package Util;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by dong.zhao on 2017/9/3.
 */

public class Directory {


    public static void main(String[] args) {
       // System.out.println(walk("."));

        /*
        for(File file: Directory.walk(".")) {
            System.out.println("Test:"+file.getName());
            file.getCanonicalFile();
        }
        */
    }



    public static TreeInfo walk(String start) {
        return recurseDir(new File(start), ".*", start);
    }

    public static class TreeInfo implements Iterable<File> {
        public List<File> files = new ArrayList<File>();
        public List<File> dirs = new ArrayList<File>();


        public Iterator<File> iterator() {
            return files.iterator();
        }



        void addAll(TreeInfo other) {
            files.addAll(other.files);
            dirs.addAll(other.dirs);
        }

        public String toString() {
            return "String from TreeInfo";
        }
    }

    static TreeInfo recurseDir(File startDir, String regex, String curDir) {
        TreeInfo result = new TreeInfo();

        for(File item: startDir.listFiles()) {
            if(item.isDirectory())
            {
                //System.out.println("D:"+curDir+"->"+item.getName());
                result.dirs.add(item);
                result.addAll(recurseDir(item, regex, curDir + "->" + item.getName()));

            }
            else
            {
                System.out.println("F:"+curDir+"->" + item.getName());
                result.files.add(item);
            }
        }
        return result;

    }


}
