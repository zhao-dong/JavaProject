package DesignPattern.SimpleFactory;

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

interface IFactory
{
    public Operation CreateOperation();
}

class AddFactory implements IFactory
{
    @Override
    public Operation CreateOperation() {
        return new OperationAdd();
    }
}

class SubFactory implements IFactory
{
    @Override
    public Operation CreateOperation() {
        return new OperationSub();
    }
}

//
//简单工厂模式的最大优点是在于工厂类中包含了必要的逻辑判断
//根据客户端的选择条件动态实例化相关的类，对于客户端来说，
//去除了与具体产品的依赖。
//


public class exam2 {

    public static void main(String[] args)
    {
        IFactory operFactory  = new AddFactory();
        Operation oper = operFactory.CreateOperation();
        oper.operA = 10.0;
        oper.operB = 11.1;
        System.out.println(oper.getResult());
    }

}
