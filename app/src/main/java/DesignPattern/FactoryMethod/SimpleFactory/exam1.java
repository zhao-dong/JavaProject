package DesignPattern.FactoryMethod.SimpleFactory;

/**
 * Created by dong.zhao on 2018/4/12.
 */

abstract class Operation
{
    public double operA;
    public double operB;
    abstract public double getResult();
}

class OperationAdd extends Operation
{
    public double getResult() {
        return operA + operB;
    }
}

class OperationSub extends Operation
{
    @Override
    public double getResult() {
        return operA - operB;
    }
}

class OperationFactory
{
    public static Operation createOperate(String operate)
    {
        Operation oper = null;
        switch(operate)
        {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSub();
                break;
        }
        return oper;
    }
}

public class exam1 {

    public static void main(String[] args)
    {
        Operation oper = OperationFactory.createOperate("+");
        oper.operA = 10.0;
        oper.operB = 11.1;
        System.out.println(oper.getResult());
    }

}
