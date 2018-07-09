package Util;

import java.util.ArrayList;

/**
 * Created by dong.zhao on 2018/1/29.
 */

class Item
{
    public int i;
    public String str;
    public Item(int i, String str)
    {
        this.i = i;
        this.str = str;
    }

    @Override
    public String toString() {
        return i + str;
    }
}

public class ArrayListAndItem {

    public static void main(String[] args)
    {
        ArrayList<Item> it = new ArrayList<>();
        Item i1 = new Item(1, "ITEM1");
        Item i2 = new Item(2, "ITME2");
        Item i3 = new Item(3, "ITME3");
        it.add(i1);
        it.add(i2);
        System.out.println(it);
        i1.i = 4;
        i1.str = "ITEM4";
        it.set(it.indexOf(i2),i3);
        System.out.println(it);

    }
}
