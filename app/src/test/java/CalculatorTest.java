import org.junit.Test;

import JUnitExample.Calculator;

import static junit.framework.TestCase.assertEquals;


/**
 * Created by dong.zhao on 2018/2/4.
 */

public class CalculatorTest {


    @Test
    public void ptestAdd() throws Exception {
        Calculator calculator = new Calculator();
        int sum = calculator.add(1,2);
        assertEquals(3,sum);
    }
    @Test
    public void methodTwo() {
        System.out.println("This is methodTwo");
    }
    @Test
    public void testDiv1() throws Exception
    {
        Calculator calculator = new Calculator();
        int result = calculator.div(1,3);
        assertEquals(0, 0);
    }
    @Test
    public void testDiv2() throws Exception
    {
        Calculator calculator = new Calculator();
        int result = calculator.div(2,3);
        assertEquals(0, 0);
    }

}
