package DesignPattern.Composite;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dong.zhao on 2018/4/18.
 */

abstract class Component {

    protected String name;

    public Component(String name)
    {
        this.name = name;
    }

    abstract public void Add(Component c);
    abstract public void Remove(Component c);
    abstract public void Display(int depth);
}

class Leaf extends Component
{
    private static final String TAG = "Leaf";
    @Override
    public void Add(Component c) {
        System.out.println(TAG + "Add: Not allowed");
    }

    @Override
    public void Remove(Component c) {
        System.out.println(TAG + "Remove: Not allowed");
    }

    @Override
    public void Display(int depth) {
        System.out.println(depth + name);
        //System.out.println(new String("-",depth) + name);
    }

    public Leaf(String name)
    {
        super(name);
    }
}

class Composite extends Component
{
    private List<Component> children = new ArrayList<Component>();

    public Composite(String name)
    {
        super(name);
    }

    @Override
    public void Add(Component c) {
        children.add(c);
    }

    @Override
    public void Remove(Component c) {
        children.remove(c);
    }

    @Override
    public void Display(int depth) {

        //System.out.println(new String("-",depth) + name);
        System.out.println(depth + name);

        for (Component c:children) {
            c.Display(depth + 2);
        }
    }
}


public class exam6 {

    static public void main(String[] args)
    {
        Composite root = new Composite("root");
        root.Add(new Leaf("Leaf A"));
        root.Add(new Leaf("Leaf B"));

        root.Display(1);

        Composite comp = new Composite("Composite X");
        comp.Add(new Leaf("Leaf XA"));
        comp.Add(new Leaf("Leaf XB"));

        root.Add(comp);
        root.Display(1);
    }

}
