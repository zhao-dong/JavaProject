package Util;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by dong.zhao on 2017/11/19.
 */


class WeatherData extends Observable{

    private float temperature;

    public void setMeasurements(float temperature)
    {
        this.temperature = temperature;
        measurementsChanged();
    }

    public float getTemperature()
    {
        return temperature;
    }

    public void measurementsChanged(){
        setChanged();
        notifyObservers();
    }

    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    @Override
    public void notifyObservers(Object arg) {
        super.notifyObservers(arg);
    }

    @Override
    public synchronized void deleteObservers() {
        super.deleteObservers();
    }

    @Override
    protected synchronized void setChanged() {
        super.setChanged();
    }
}

public class ObserverTest implements Observer{

    private float temperature;

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherData)
        {
           temperature =  ((WeatherData) o).getTemperature();
        }
        display();
    }

    private void display()
    {
        System.out.println(temperature);
    }

    static public void main(String args[]) {
        WeatherData wd = new WeatherData();
        ObserverTest ot = new ObserverTest();
        wd.addObserver(ot);

        wd.setMeasurements(10);
        wd.setMeasurements(100);
    }
}
