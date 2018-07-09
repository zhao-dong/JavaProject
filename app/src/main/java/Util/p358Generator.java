package Util;

import android.support.annotation.NonNull;

import java.util.Iterator;
import java.util.Random;

/**
 * Created by dong.zhao on 2017/12/9.
 */


interface Generator<T> {
    T next();
}
 class Coffee {
    private static long counter = 0;
    private final long id = counter++;
    public String toString()
    {
        return getClass().getSimpleName() + "  " + id;
    }
}

class Latte extends Coffee{}
class Mocha extends Coffee{}
class Cappuccino extends Coffee{}
class Americano extends Coffee{}
class Breve extends Coffee{}

/*
class test1 implements Iterable<Coffee>
{
    @NonNull
    @Override
    public Iterator<Coffee> iterator() {
        return null;
    }

    class test1Iterator implements Iterator<Coffee>
    {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Coffee next() {
            return null;
        }

        @Override
        public void remove() {

        }
    }
}
*/

public class p358Generator implements Iterable<Coffee>, Generator<Coffee> {

    private Class[] types = {Latte.class, Mocha.class, Cappuccino.class, Americano.class, Breve.class };
    private static Random random = new Random(47);
    private int size = 0;

    public p358Generator(int sz) { size = sz; }
    public p358Generator() {}

    @Override
    public Coffee next() {
        try {
            return (Coffee)types[random.nextInt(types.length)].newInstance();
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @Override
    public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }

    class CoffeeIterator implements Iterator<Coffee>
    {
        int count = size;

        @Override
        public boolean hasNext() {
            return count > 0;
        }

        @Override
        public Coffee next() {
            count--;
            return p358Generator.this.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args)
    {
        p358Generator gen = new p358Generator();
        for(int i = 0; i < 5; i++)
            System.out.println(gen.next());
        for(Coffee c: new p358Generator(5) )
            System.out.println(c);
    }
}
