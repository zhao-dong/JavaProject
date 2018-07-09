package Util;

/**
 * Created by dong.zhao on 2018/1/9.
 */

public class p396 {

    static void rawArgs(Holder holder, Object arg)
    {
        holder.set(arg);
        Object obj = holder.get();
    }

    static void unboundedArg(Holder<?> holder, Object arg)
    {
        //holder.set(arg);
        //Object obj = holder.get();
    }

    public static void main(String[] args) {
        Holder raw = new Holder<Long>();
        raw = new Holder();
        Holder<Long> qualified = new Holder<Long>();
        Holder<?> unbounded = new Holder<Long>();
        Holder<? extends Long> bounded = new Holder<Long>();

        Long lng = 1l;
        rawArgs(raw,lng);
        rawArgs(qualified,lng);
        rawArgs(unbounded,lng);
        rawArgs(bounded,lng);

       // unboundedArg(raw, lng);

    }

}
