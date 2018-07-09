package Util;

/**
 * Created by dong.zhao on 2018/1/20.
 */

class Processor {
    public Object process(Object input) {
        System.out.println("in Processor::process");
        return input;
    }
    public String toString() {
        return getClass().getSimpleName();
    }

}

class Upcase extends Processor
{
    @Override
    public String process(Object input)
    {
        return ((String)input).toUpperCase();
    }
}
class Downcase extends Processor
{
    @Override
    public String process(Object input)
    {
        return ((String)input).toLowerCase();
    }
}

public class p175Apple  {

    public static void process(Processor p, Object s)
    {
        System.out.println("Using processor " + p);
        System.out.println(p.process(s));
    }


    public static void main(String[] args)
    {
        process(new Upcase(), "heLLo");
        process(new Downcase(), "World");

        Processor p = new Upcase();
        System.out.println(p);
        System.out.println(p.process("yyy"));

    }
}
