package Util;

import android.database.Observable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong.zhao on 2017/11/29.
 */

interface SetObserver<E>
{
    void added(item67 set, E element);
}

public class item67 <E> {

    private final List<SetObserver<E>> observers = new ArrayList<SetObserver<E>>();

    public void addObserver(SetObserver<E> observer){
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public boolean removeObserver(SetObserver<E> observer) {
        synchronized (observers) {
            return observers.remove(observer);
        }
    }

    private void notfiyElementAdded(E element)
    {
        synchronized (observers) {
            for(SetObserver<E> observer: observers)
                observer.added(this, element);
        }
    }

    public void add(E element)
    {
        notfiyElementAdded(element);
    }

    public static void main(String[] args) {

        item67<Integer> myTest = new item67<Integer>();
        myTest.addObserver(new SetObserver<Integer>() {
            @Override
            public void added(item67 set, Integer element) {
                System.out.println(element);
                if(element == 23)
                {
                    set.removeObserver(this);
                }
            }
        });

        for (int i = 0; i < 100; i++)
        {
            myTest.add(i);
        }
    }

}
