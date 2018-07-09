package DesignPattern.Bridge;

/**
 * Created by dong.zhao on 2018/4/17.
 */

abstract class HandsetSoft
{
    abstract public void Run();
}

class HandsetGame extends HandsetSoft
{
    @Override
    public void Run() {
        System.out.println("允许手机程序");
    }
}

class HandsetAddressList extends HandsetSoft
{
    @Override
    public void Run() {
        System.out.println("允许手机通信录");
    }
}

abstract class HandsetBrand
{
    protected HandsetSoft soft;

    public void SetHandsetSoft(HandsetSoft soft)
    {
        this.soft = soft;
    }

    public abstract void run();
}

class HandsetBrandN extends HandsetBrand
{
    @Override
    public void run() {
        soft.Run();
    }
}

class HandsetBrandM extends HandsetBrand
{
    @Override
    public void run() {
        soft.Run();
    }
}

public class exam5 {

    static public void main(String[] args)
    {
        HandsetBrand ab = new HandsetBrandN();
        ab.SetHandsetSoft(new HandsetGame());
        ab.run();


    }


}


