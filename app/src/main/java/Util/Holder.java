package Util;

/**
 * Created by dong.zhao on 2018/1/9.
 */
//P392
public class Holder <T> {

    private T value;
    public Holder() {}
    public Holder(T val) { value = val;}
    public void set (T val ) { value = val; }
    public T get() { return value;}
    public boolean equals(Object obj) { return value.equals(obj);}
}
