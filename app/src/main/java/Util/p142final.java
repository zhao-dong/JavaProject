package Util;

/**
 * Created by dong.zhao on 2018/2/8.
 */


class Gizmo {
    public int i;
}

public class p142final {

    public void with(final Gizmo g)
    {
        g.i = 10;
        //!g = new Gizmo();
    }

    public static void main(String[] args)
    {

        p142final p = new p142final();
        Gizmo gizmo = new Gizmo();
        p.with(gizmo);

    }
}
