package Util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by dong.zhao on 2018/2/4.
 */

public class P621 {

    @AnoTest(id = 99, description = "haha") void testExecute()
    {
        System.out.println("In testExcuet");
    }


}


@Target(ElementType .METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface AnoTest {
    public int id() default 100;
    public String description() default "hello world string from AnoTest";
}