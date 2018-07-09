package Util;

/**
 * Created by dong.zhao on 2018/1/24.
 */

enum Activity { SITTING, LYING, STANDING, HOPPING, RUNNING,
    DODGING, JUMPING, FALLING, FLYING,}

public class p597RandomTest {
    public static void main(String[] args)
    {
        for(int i = 0; i < 20; i++)
        {
            System.out.println(p596Enums.random(Activity.class) + " ");
        }
    }

}
