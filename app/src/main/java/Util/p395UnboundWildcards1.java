package Util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong.zhao on 2018/1/9.
 */

public class p395UnboundWildcards1 {

    static List list1;
    static List <?> list2;
    static List<? extends Object> list3;

    static void assign1(List list)
    {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign2(List<?> list)
    {
        list1 = list;
        list2 = list;
        list3 = list;
    }

    static void assign3(List<? extends Object> list)
    {
        list1 = list;
        list2 = list;
        list3 = list;
    }


    public static void main(String[] args)
    {
        assign1(new ArrayList<>());
        assign2(new ArrayList());
        assign3(new ArrayList());


        assign1(new ArrayList<String>());
        assign2(new ArrayList<String>());
        assign3(new ArrayList<String>());

        List<?> wildlist = new ArrayList<String>();
        assign1(wildlist);
        assign2(wildlist);
        assign3(wildlist);
    }



}
