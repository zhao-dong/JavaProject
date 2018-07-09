package Util;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by dong.zhao on 2018/1/18.
 */

class Element {
    private String ident;
    public Element(String id) {
        ident = id;
        System.out.println("Constructing " +
                getClass().getSimpleName() + " " + ident);
    }
    public String toString() { return ident;}
    public int hashCode() { return ident.hashCode();}
    public boolean equals(Object r)
    {
        return r instanceof Element && ident.equals(((Element)r).ident);
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing " +
                getClass().getSimpleName() + " " + ident);
    }
}

class Key extends Element {
    public Key(String id) { super(id);}
}

class Value1 extends Element {
    public Value1(String id) { super(id);}
}

public class p519WeakHashMap {

    public static void main(String[] args) {

        int size = 10;
        Key[] keys = new Key[size];

        Value1 v1 = new Value1("x");
        v1 = null;

        WeakHashMap<Key, WeakReference<Value1>> map = new WeakHashMap<Key, WeakReference<Value1>>();

        for (int i = 0; i < size; i++)
        {
            Key k = new Key(Integer.toString(i));
            Value1 v = new Value1(Integer.toString(i));

            if (i % 3 == 0) {
                keys[i] = k;
            }
            map.put(k, new WeakReference<Value1>(v));
            System.out.println(map.get(k));
        }
        System.out.println(map);
        System.out.println("Before calling system.gc()!!!");
        System.gc();

        System.out.println("After calling system.gc()!!!");
        System.out.println(map);
        System.out.println(map.get(keys[3]));
        System.out.println(map.values());


        /*
        // 初始化3个“弱键”
        String w1 = new String("one");
        String w2 = new String("two");
        String w3 = new String("three");
        // 新建WeakHashMap
        Map wmap = new WeakHashMap();

        // 添加键值对
        wmap.put(w1, "w1");
        wmap.put(w2, "w2");
        wmap.put(w3, "w3");

        // 打印出wmap
        System.out.printf("\nwmap:%s\n",wmap );

        // containsKey(Object key) :是否包含键key
        System.out.printf("contains key two : %s\n",wmap.containsKey("two"));
        System.out.printf("contains key five : %s\n",wmap.containsKey("five"));

        // containsValue(Object value) :是否包含值value
        System.out.printf("contains value 0 : %s\n",wmap.containsValue(new Integer(0)));

        // remove(Object key) ： 删除键key对应的键值对
        wmap.remove("three");

        System.out.printf("wmap: %s\n",wmap );

         // ---- 测试 WeakHashMap 的自动回收特性 ----

        // 将w1设置null。
        // 这意味着“弱键”w1再没有被其它对象引用，调用gc时会回收WeakHashMap中与“w1”对应的键值对
        w1 = null;
        // 内存回收。这里，会回收WeakHashMap中与“w1”对应的键值对
        System.gc();

        // 遍历WeakHashMap
        Iterator iter = wmap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry en = (Map.Entry)iter.next();
            System.out.printf("next : %s - %s\n",en.getKey(),en.getValue());
        }
        // 打印WeakHashMap的实际大小
        System.out.printf(" after gc WeakHashMap size:%s\n", wmap.size());
        */

    }
}

