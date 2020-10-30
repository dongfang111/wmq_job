package com.example.demo.observer.push;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气数据-主题子类
 * @author 王明卿
 * @version 1.0
 * @since 2020/4/5 21:07
 **/
public class WeatherData implements Subject{

    //存储观察者
    private List<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    /**
     * 当天气数据更新时，通知观察者
     */
    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        //更改气象数据
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        //通知观察者
        measurementsChanged();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
