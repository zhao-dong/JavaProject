package Util;

/**
 * Created by dong.zhao on 2018/1/23.
 */

enum Signal { GREEN("绿色"), RED("红色"), YELLOW("黄色");
    private String des;
    private Signal(String des)
    {
      this.des = des;
    }

    @Override
    public String toString() {
        return des;
    }
}

public class p593switchdefault {

    public static void main(String[] args)
    {
        Signal sg = Signal.GREEN;
        System.out.println(sg);
        switch(sg)
        {
            case GREEN:
                break;
            case RED:
                break;
            case YELLOW:
                return;
                //break;

        }
    }

}
